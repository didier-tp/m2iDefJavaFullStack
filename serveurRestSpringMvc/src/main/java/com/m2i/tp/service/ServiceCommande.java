package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Commande;
import com.m2i.tp.entity.Produit;

public interface ServiceCommande {
	
	public Commande creerCommande(Long numClient,List<Produit> listeProd);
	/*
	public Commande creerCommandePourClient(Long numClient);
	public void ajouterProduitCommande(Long numCommande,Long numProduit);
	public void ajouterProduitsCommande(Long numCommande,List<Produit> listeProd);
	*/
	public Commande rechercherCommandeParNumero(Long numCommande);
	public List<Commande> rechercherCommandesPourClient(Long numClient);
	
	//....

}
