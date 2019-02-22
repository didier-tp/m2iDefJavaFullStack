package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.m2i.tp.Stats;

public class TestStats {

	private Stats s; // à tester
	// private static Stats s; // static pas approprié sur ce type de composant

	/*
	 * //satic pas approprié sur composant ayant besoin d'être ré-initialisé
	 * 
	 * @BeforeClass public static void init() {
	 */
	@Before
	public void init() {
		s = new Stats();
	}

	@Test
	public void testSomme() {
		s.add(5.0);
		s.add(8.0);
		s.add(10.0);
		double resSomme = s.somme();
		// verifier que resSomme vaut 5+8+10=23
		Assert.assertEquals(23.0, resSomme, 0.0001);
	}

	@Test
	public void testMoyenne() {
		s.add(6.0);
		s.add(8.0);
		s.add(10.0);
		double resMoy = s.moyenne();
		// verifier que resMoy vaut 8
		Assert.assertEquals(8.0, resMoy, 0.0001);
	}

}
