package com.m2i.tp.dao;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Compte;

public interface CompteDao extends CrudRepository<Compte,Long> {
	
	/*
	 principales méthodes héritées de CrudRepository:
	 
	 public List<Compte> findAll();
	 public Optional<Compte> findById(Long num);
	 public  Compte  save(Compte compte);
	 void deleteById(Long num);
	 */

}
