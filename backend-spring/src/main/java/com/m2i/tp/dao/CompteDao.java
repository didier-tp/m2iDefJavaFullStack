package com.m2i.tp.dao;

import java.util.List;

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
	
	//peut se coder via une @NamedQuery(name="Compte.findByClientNum") sur la classe Compte 
	public List<Compte> findByClientNum(long numClient);
	
	public List<Compte> findByClientNumero(long numClient); //codé automatiquement par convention de noms (cpt.client.numero)

}
