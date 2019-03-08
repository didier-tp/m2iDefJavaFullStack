package com.m2i.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Client;
//Spring data va générer automatiquement une classe qui va implémenter
//cette interface.
public interface DaoClient extends CrudRepository<Client,Long>{
   /*
    principales méthodes héritées:
	    save(entity)
	    findById(id)
	    findAll()
	    deleteById(id)
    */
	
	//via des conventions de nom "findBy" et  "StartingWith"  sur cette méthode , le code
	//d'implémentation de la requête sera généré automatiquement
	public List<Client> findByNomStartingWith(String debutNom);
}
