package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Produit;

/*
 * Service métier (Business Service)
 * avec :
 *    - règle de gestion (à vérifier)
 *    - transactions
 *    - méthodes spécifiques au métier
 *    - traitements délégués aux DAOs .
 */
public interface ServiceProduit {
	public void ajouterProduit(Produit p);// à déléguer au dao

	public List<Produit> allProduits();// à déléguer au dao

	public void appliquerPromotion(double tauxReductionPct);
	// ...
}
