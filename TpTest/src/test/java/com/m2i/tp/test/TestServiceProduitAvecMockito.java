package com.m2i.tp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceProduit;
import com.m2i.tp.service.ServiceProduitImpl;

public class TestServiceProduitAvecMockito {

	private ServiceProduit s; // service à tester
	private DaoProduit mockitoDao;

	@Before
	public void init() {
		s = new ServiceProduitImpl();
		// Rappel : DaoProduit = interface du composant dao en arrière plan
		mockitoDao = Mockito.mock(DaoProduit.class);
		((ServiceProduitImpl) s).setDaoProduit(mockitoDao);
	}

	@Test
	public void testPromo() {

		// préparer le comportement du dao en arrièrePlan List<Produit>
		List<Produit> listProduitsPourDaoMockito = new ArrayList<Produit>();
		listProduitsPourDaoMockito.add(new Produit(1L, "produit1", 20.0));
		listProduitsPourDaoMockito.add(new Produit(2L, "produit2", 30.0));
		Mockito.when(mockitoDao.allProduits()).thenReturn(listProduitsPourDaoMockito);
		/*
		 * // ajouter 2 produit: s.ajouterProduit(new Produit(null, "produit1", 20.0));
		 * s.ajouterProduit(new Produit(null, "produit2", 30.0));
		 */
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
		// demander à Mockito de vérifier que le service à tester
		// a bien appeler 2 fois la méthode updateProduit() sur la
		// doublure générée par mockito (mock=stub+spy).
		Mockito.verify(mockitoDao, Mockito.times(2)).updateProduit(Mockito.any());
	}

}
