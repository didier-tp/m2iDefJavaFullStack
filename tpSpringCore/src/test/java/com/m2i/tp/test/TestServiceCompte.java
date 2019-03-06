package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.tp.entity.Compte;
import com.m2i.tp.service.ServiceCompte;

//il faut spring-test dans pom.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/mySpringConf.xml"})
public class TestServiceCompte {

	@Autowired
	private ServiceCompte serviceCompte; //à tester
	
	@Test
	public void testCrud() {
		Compte cA = new Compte(null,"compte A",50.0);
		serviceCompte.sauvegarder(cA);
		Long numCptA = cA.getNumero();
		
		Compte cArelu = serviceCompte.rechercherCompteParNumero(numCptA);
		Assert.assertEquals(50.0, cArelu.getSolde(),0.0001);
		//...
		
	}
	
	@Test
	public void testBonVirement() {
		//...
	}
}
