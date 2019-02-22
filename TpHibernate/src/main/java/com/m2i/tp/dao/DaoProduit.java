package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Produit;

// DAO = Data Access Object avec methodes CRUD
// et throws RuntimeException implicite
public interface DaoProduit {
	public void createProduit(Produit p);

	public void updateProduit(Produit p);

	public void deleteProduit(Long numeroProduit);

	public Produit produitByNum(Long numProduit);

	public List<Produit> allProduits();

	public List<Produit> produitsByCategorieId(Long idCategorie);

	public List<Produit> produitsByCategorieName(String categorieName);
}
