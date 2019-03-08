package com.m2i.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Produit;
//Spring data va générer automatiquement une classe qui va implémenter
//cette interface.
public interface DaoProduit extends CrudRepository<Produit,Long>{
   /*
    principales méthodes héritées:
	    save(entity)
	    findById(id)
	    findAll()
	    deleteById(id)
    */
	
	//via des conventions de nom sur cette méthode , le code
	//d'implémentation de la requête sera généré automatiquement
	public List<Produit> findByPrixLessThan(double prixMaxi);
}
