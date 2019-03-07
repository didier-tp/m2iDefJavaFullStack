package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Produit;

public interface ServiceProduit {
	public Produit produitSelonNumero(Long numProd);
	public void sauvegarderProduit(Produit p);
	public void supprimerProduit(Long numProd);
	public List<Produit> tousProduits();
	public List<Produit> produitsPasChers(double prixMaxi);
	
}
