package com.m2i.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Commande;
//Spring data va générer automatiquement une classe qui va implémenter
//cette interface.
public interface DaoCommande extends CrudRepository<Commande,Long>{

	
   /*
    principales méthodes héritées:
	    save(entity)
	    findById(id)
	    findAll()
	    deleteById(id)
    */
	
	//codée via @NamedQuery(name="Commande.findCommandeByClientId",...)
	List<Commande> findCommandeByClientId(Long numClient);
}
