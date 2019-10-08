package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.Test;//JUnit 4
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.MySpringBootApplication;
import com.m2i.tp.entity.Compte;
import com.m2i.tp.service.CompteService;

//Test unitaire basé sur JUnit4 (et Spring)
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestCompteService {
	//logger (slf4j) et src/main/resources/log4j.properties
	static Logger logger = LoggerFactory.getLogger(TestCompteService.class);
	
	@Autowired //injection de dépendance (Spring)  //@Inject() = equivalent EJB/CDI de @Autowired
	private CompteService compteService; //chose à tester
	
	
	@Test
	public void testBonTransfert() {
		Compte cA = new Compte(); cA.setLabel("compte A");cA.setSolde(150.0);
		cA = compteService.sauvegarderCompte(cA);
		Compte cB = new Compte(); cB.setLabel("compte B");cB.setSolde(10.0);
		cB = compteService.sauvegarderCompte(cB);
		compteService.transferer(50, cA.getNumero(), cB.getNumero());
		//vérifier soldes modifiés:
		Compte cAReluApresTransfert = compteService.rechercherCompteParNum(cA.getNumero());
		Compte cBReluApresTransfert = compteService.rechercherCompteParNum(cB.getNumero());
		logger.info("cAReluApresTransfert="+cAReluApresTransfert);
		logger.info("cBReluApresTransfert="+cBReluApresTransfert);
		Assert.assertEquals(150 - 50, cAReluApresTransfert.getSolde(),0.0001);
		Assert.assertEquals(10 + 50, cBReluApresTransfert.getSolde(),0.0001);
	}
	
	@Test
	public void testMauvaisTransfert() {
		Compte cA = new Compte(); cA.setLabel("compte AA");cA.setSolde(150.0);
		cA = compteService.sauvegarderCompte(cA);
		Compte cB = new Compte(); cB.setLabel("compte BB");cB.setSolde(10.0);
		cB = compteService.sauvegarderCompte(cB);
		try {
			compteService.transferer(50, cA.getNumero(), -cB.getNumero());
			Assert.fail("exception non lévée = pas normal");
		} catch (Exception e) {
			logger.info(e.getMessage());
			//e.printStackTrace();
		}
		//vérifier soldes modifiés:
		Compte cAReluApresTransfert = compteService.rechercherCompteParNum(cA.getNumero());
		Compte cBReluApresTransfert = compteService.rechercherCompteParNum(cB.getNumero());
		logger.info("cAReluApresTransfert="+cAReluApresTransfert);
		logger.info("cBReluApresTransfert="+cBReluApresTransfert);
		Assert.assertEquals(150 , cAReluApresTransfert.getSolde(),0.0001);
		Assert.assertEquals(10 , cBReluApresTransfert.getSolde(),0.0001);
	}
	
	@Test
	public void testCrud() {
		Compte c1 = new Compte(); c1.setLabel("compte 1");c1.setSolde(150.0); 
		compteService.sauvegarderCompte(c1);
		Long idC1 = c1.getNumero();
		logger.info("idC1="+idC1); //ou logger.debug()
		
		//relire pour vérifier ajout:
		Compte c1ReluDepuisBase = compteService.rechercherCompteParNum(idC1);
		Assert.assertEquals(c1ReluDepuisBase.getLabel(), "compte 1");
		Assert.assertEquals(c1ReluDepuisBase.getSolde(), 150.0, 0.0001);
		logger.info("c1ReluDepuisBase="+c1ReluDepuisBase);//ou logger.debug()
		
	}
	
	
	

}
