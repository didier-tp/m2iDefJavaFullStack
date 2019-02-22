package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.m2i.tp.CalculateurTva;

public class TestCalculateurTva {

	private Logger logger = LoggerFactory.getLogger(TestCalculateurTva.class);

	private static CalculateurTva c; // composant à tester

	@BeforeClass
	public static void initialisation() {
		c = new CalculateurTva();
	}

	@Test
	public void testTva() {
		double resTva = c.tva(200, 20);
		logger.trace("pour ht=200 et taux=20, resTva=" + resTva);
		// vérifier que le résultat vaut 40:
		Assert.assertEquals(40.0, resTva, 0.0001);
	}

	@Test
	public void testTvaV2() {
		try {
			double resTva = c.tva(200, -20);
			Assert.fail("echec du test si pas d'exception remontée");
		} catch (Exception e) {
			logger.trace("exception nornale pour taux=-20 ", e.getMessage());
			// e.printStackTrace();
		}
	}

	@Test
	public void testTtc() {
		double resTtc = c.ttc(200, 20);
		// vérifier que le résultat vaut 240:
		Assert.assertEquals(240.0, resTtc, 0.0001);
	}

	@Test
	public void testElementaire() {
		int resAdd = 1 + 1;
		Assert.assertTrue(resAdd == 2);
	}

}
