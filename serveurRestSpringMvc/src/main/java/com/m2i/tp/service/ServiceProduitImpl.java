package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.entity.Produit;
@Service //cas particulier de @Component
@Transactional
public class ServiceProduitImpl implements ServiceProduit {
	@Autowired //pour injecter l'instance de la classe générée par spring-data
	           //qui implémente l'interface via jpa
	private DaoProduit daoProduit;
	
	public Produit produitSelonNumero(Long numProd) {
		// findById() renvoie un objet de type Optional<Produit>
		//return daoProduit.findById(numProd).get();
		return daoProduit.findById(numProd).orElse(null);
	}
	public void sauvegarderProduit(Produit p) {
		daoProduit.save(p);
	}
	public void supprimerProduit(Long numProd) {
		daoProduit.deleteById(numProd);
	}
	public List<Produit> tousProduits() {
		return (List<Produit>) daoProduit.findAll();
	}
	public List<Produit> produitsPasChers(double prixMaxi) {
		return daoProduit.findByPrixLessThan(prixMaxi);
	}
}
