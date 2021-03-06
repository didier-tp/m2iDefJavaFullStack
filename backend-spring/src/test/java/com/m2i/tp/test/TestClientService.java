package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;//JUnit 4
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.MySpringBootApplication;
import com.m2i.tp.entity.Client;
import com.m2i.tp.service.ClientService;

//Test unitaire basé sur JUnit4 (et Spring)
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestClientService {
	
	@Autowired //injection de dépendance (Spring)  //@Inject() = equivalent EJB/CDI de @Autowired
	private ClientService clientService; //chose à tester
	
	
	@Test
	public void testCrud() {
		Client c1 = new Client(); c1.setUsername("user1");
		c1.setPassword("pwd1"); c1.setRoles("user,admin");
		clientService.sauvegarderClient(c1);
		Long idC1 = c1.getNumero();
		System.out.println("idC1="+idC1); //ou logger.debug()
		
		//relire pour vérifier ajout:
		Client c1ReluDepuisBase = clientService.rechercherClientParNum(idC1);
		Assert.assertEquals(c1ReluDepuisBase.getUsername(), "user1");
		Assert.assertEquals(c1ReluDepuisBase.getPassword(), "pwd1");
		System.out.println("c1ReluDepuisBase="+c1ReluDepuisBase);//ou logger.debug()
		
	}
	
	
	

}
