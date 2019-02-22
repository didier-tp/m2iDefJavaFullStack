package com.m2i.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.dao.DaoProduitHibernate;
import com.m2i.tp.entity.Produit;

import util.TestWithEntityManager;

public class TestDaoProduit extends TestWithEntityManager {

	private Logger logger = LoggerFactory.getLogger(TestDaoProduit.class);
	private DaoProduit dao; // à tester

	/*
	 * @Before public void initDao() { dao = new DaoProduitHibernate(); // ou new
	 * DaoProduitSimu(); // ou new ProduitDaoJdbc() ou ... }
	 */

	@Override
	protected void injectEntityManagerIntoService() {
		// NB: cette méthode est déclenchée par un @Before hérité
		if (dao == null) {
			dao = new DaoProduitHibernate();
		}
		((DaoProduitHibernate) dao).setEntityManager(this.entityManager);
	}

	@Test
	public void testAllProduits() {
		// ajouter 2 produits
		Produit pA = new Produit(null, "produitA", 36.2);
		dao.createProduit(pA);
		Produit pB = new Produit(null, "produitB", 68.2);
		dao.createProduit(pB);
		// appeler allProduits() , vérifier taille liste >= 2
		List<Produit> listeProd = dao.allProduits();
		logger.debug("listeProd=" + listeProd);
		Assert.assertNotNull(listeProd);
		Assert.assertTrue(listeProd.size() >= 2);
		// supprimer les 2 produits ajoutés
		// dao.deleteProduit(pA.getNumero());
		// dao.deleteProduit(pB.getNumero());
	}

	@Test
	public void testCrud() {
		// 1. ajouter un élément en base
		Produit p = new Produit(null, "produit xy", 56.2);
		dao.createProduit(p);
		Long numProd = p.getNumero(); // recupérer numero auto incrémenté
		// 2. le relire (rechercher en base) pour vérifier l'ajout
		Produit pRelu = dao.produitByNum(numProd);
		Assert.assertEquals("produit xy", pRelu.getLabel());
		Assert.assertEquals(56.2, pRelu.getPrix(), 0.00001);
		// 3. on modifie en mémoire puis en base (update)
		pRelu.setPrix(58.3);
		pRelu.setLabel("prodXy");
		dao.updateProduit(pRelu);
		// 4. relecture en base pour vérifier update
		Produit pRelu2 = dao.produitByNum(numProd);
		Assert.assertEquals("prodXy", pRelu2.getLabel());
		Assert.assertEquals(58.3, pRelu2.getPrix(), 0.00001);
		// 5. suppression
		dao.deleteProduit(numProd);
		// 6. relecture pour verifier que ça n'existe plus
		Produit pRelu3 = dao.produitByNum(numProd);
		Assert.assertTrue(pRelu3 == null);
	}

}
