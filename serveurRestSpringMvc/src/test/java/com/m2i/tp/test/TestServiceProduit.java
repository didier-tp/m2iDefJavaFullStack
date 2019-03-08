package com.m2i.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.MySpringBootApplication;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceProduit;



//Test unitaire du service métier "ServiceProduit"

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceProduit {
	
	@Autowired
	private ServiceProduit serviceProduit; //à tester
	
	@Test
	public void testProduitsPasChers() {
		Produit pA = new Produit(null,"pA",50.0);
		serviceProduit.sauvegarderProduit(pA);
		Produit pB = new Produit(null,"pB",20.0);
		serviceProduit.sauvegarderProduit(pB);
		Produit pC = new Produit(null,"pC",500.0);
		serviceProduit.sauvegarderProduit(pC);
		
		List<Produit> listProd = serviceProduit.produitsPasChers(60);
		Assert.assertNotNull(listProd);
		Assert.assertTrue(listProd.size()>=2);
		System.out.println("produits avec prix <= 60 euros :" + listProd);
	}
	
	@Test
	public void testCrud() {
		
	}

}
