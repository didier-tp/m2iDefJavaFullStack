package com.m2i.tp.dao;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Devise;
//Spring data va générer automatiquement une classe qui va implémenter
//cette interface.
public interface DaoDevise extends CrudRepository<Devise,String>{
   /*
    principales méthodes héritées:
	    save(entity)
	    findById(id)
	    findAll()
	    deleteById(id)
    */
	
	//via des conventions de nom "findBy"  sur cette méthode , le code
	//d'implémentation de la requête sera généré automatiquement
	public Devise findByNom(String nomDevise);
}
