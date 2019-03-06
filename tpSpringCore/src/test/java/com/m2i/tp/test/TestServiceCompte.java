package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.tp.entity.Compte;
import com.m2i.tp.service.ServiceCompte;

//il faut spring-test dans pom.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/mySpringConf.xml"})
public class TestServiceCompte {
	
	private Logger logger = LoggerFactory.getLogger(TestServiceCompte.class);

	@Autowired
	private ServiceCompte serviceCompte; //à tester
	
	@Test
	public void testCrud() {
		Compte cA = new Compte(null,"compte A",50.0);
		serviceCompte.sauvegarder(cA);
		Long numCptA = cA.getNumero();
		
		Compte cArelu = serviceCompte.rechercherCompteParNumero(numCptA);
		logger.info("cArelu="+cArelu);
		Assert.assertEquals(50.0, cArelu.getSolde(),0.0001);
		
		//...
		
	}
	
	@Test
	public void testBonVirement() {
		Compte cA = new Compte(null,"compte A",50.0);
		serviceCompte.sauvegarder(cA);
		Compte cB = new Compte(null,"compte B",30.0);
		serviceCompte.sauvegarder(cB);
		//virement de 10 euros du compte cA vers le compte cB
		serviceCompte.virement(10.0, cA.getNumero(), cB.getNumero());
		//verifier virement
		Compte cAapresVirement = serviceCompte.rechercherCompteParNumero(cA.getNumero());
		Compte cBapresVirement = serviceCompte.rechercherCompteParNumero(cB.getNumero());
		logger.debug("avant bon virement , cA=" + cA.getSolde() + " cB=" + cB.getSolde());
		logger.debug("apres bon virement , cA=" + cAapresVirement.getSolde() 
		                               + " cB=" + cBapresVirement.getSolde());
		Assert.assertEquals(cA.getSolde()-10, cAapresVirement.getSolde(),0.01);
		Assert.assertEquals(cB.getSolde()+10, cBapresVirement.getSolde(),0.01);
	}
	
	
	
	
	
	
	
	
	
}
