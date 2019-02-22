package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.entity.Produit;

public class ServiceProduitImpl implements ServiceProduit {

	private DaoProduit daoProduit; // référence vers le dao
	// pour déléguer certains sous traitements

	// setter public pour relier le dao au service
	// serviceProduit.setDaoProduit(daoSimu ou daoJdbc ou daoJpaHibernate
	// ou daoMockito )
	public void setDaoProduit(DaoProduit daoProduit) {
		this.daoProduit = daoProduit;
	}

	@Override
	public void ajouterProduit(Produit p) {
		daoProduit.createProduit(p);
	}

	@Override
	public List<Produit> allProduits() {
		return daoProduit.allProduits();
	}

	@Override
	public void appliquerPromotion(double tauxReductionPct) {
		List<Produit> produits = daoProduit.allProduits();
		for (Produit p : produits) {
			p.setPrix(p.getPrix() * (100 - tauxReductionPct) / 100);
			daoProduit.updateProduit(p);
		}
	}

}
