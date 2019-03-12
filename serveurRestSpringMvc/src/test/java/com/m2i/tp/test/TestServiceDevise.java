package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.MySpringBootApplication;
import com.m2i.tp.entity.Devise;
import com.m2i.tp.service.ServiceDevise;



//Test unitaire du service métier "ServiceProduit"

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceDevise {
	
	private Logger logger = LoggerFactory.getLogger(TestServiceDevise.class);
	
	@Autowired
	private ServiceDevise serviceDevise; //à tester
	
	@Test
	public void testRechercheDeviseParNom() {
		Devise euro = new Devise("EUR","euro",0.9);
		serviceDevise.creerDevise(euro);
		
		Devise dollar = new Devise("USD","dollar",1.0);
		serviceDevise.creerDevise(dollar);
		
		
		Devise euroReluViaName = serviceDevise.rechercherDeviseParNom("euro");
		Assert.assertNotNull(euroReluViaName);
		Assert.assertEquals(euro.getCode(),euroReluViaName.getCode());
		Assert.assertEquals(euro.getNom(),euroReluViaName.getNom());
		Assert.assertEquals(euro.getDChange(),euroReluViaName.getDChange());
		logger.info("euroReluViaName :" + euroReluViaName);
		
		serviceDevise.supprimerDevise("EUR");
		serviceDevise.supprimerDevise("USD");
	}
	
	@Test
	public void testConversion() {
		Devise euro = new Devise("EUR","euro",0.9);
		serviceDevise.creerDevise(euro);
		
		Devise dollar = new Devise("USD","dollar",1.0);
		serviceDevise.creerDevise(dollar);
		
		
		double sommeConvertie = serviceDevise.convertir(100.0,"EUR" , "USD");
		
		logger.info("100 euros , en dollar  :" + sommeConvertie);
		
		serviceDevise.supprimerDevise("EUR");
		serviceDevise.supprimerDevise("USD");
	}
	
	@Test
	public void testCrud() {
		
	}

}
