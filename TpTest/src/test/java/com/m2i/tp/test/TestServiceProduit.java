package com.m2i.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.m2i.tp.dao.DaoProduitSimu;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceProduit;
import com.m2i.tp.service.ServiceProduitImpl;

public class TestServiceProduit {

	private ServiceProduit s; // service à tester

	@Before
	public void init() {
		s = new ServiceProduitImpl();
		((ServiceProduitImpl) s).setDaoProduit(new DaoProduitSimu());
	}

	@Test
	public void testPromo() {
		// ajouter 2 produit:
		s.ajouterProduit(new Produit(null, "produit1", 20.0));
		s.ajouterProduit(new Produit(null, "produit2", 30.0));
		// applique une promo de 5% :
		s.appliquerPromotion(5);
		// récuperer tous les produits et verifier prix changés:
		List<Produit> listeProd = s.allProduits();
		double prixTotal = 0;
		for (Produit p : listeProd) {
			prixTotal += p.getPrix();
		}
		// à peaufiner ultérieurement:
		Assert.assertEquals(prixTotal, (20 + 30) * 0.95, 0.0001);
	}

}
