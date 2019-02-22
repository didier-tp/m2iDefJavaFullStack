package com.m2i.tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.m2i.tp.entity.Produit;

public class DaoProduitSimu implements DaoProduit {

	private Map<Long, Produit> mapProduits = new HashMap<>();
	private Long maxNumProd = 0L; // pour simuler auto_increment

	@Override
	public void createProduit(Produit p) {
		this.maxNumProd++;// simuler auto_increment
		p.setNumero(maxNumProd);
		mapProduits.put(maxNumProd, p);
	}

	@Override
	public void updateProduit(Produit p) {
		mapProduits.put(p.getNumero(), p);
	}

	@Override
	public void deleteProduit(Long numeroProduit) {
		mapProduits.remove(numeroProduit);
	}

	@Override
	public Produit produitByNum(Long numProduit) {
		return mapProduits.get(numProduit);
	}

	@Override
	public List<Produit> allProduits() {
		return new ArrayList<Produit>(mapProduits.values());
	}

}
