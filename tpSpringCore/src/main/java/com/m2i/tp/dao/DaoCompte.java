package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Compte;

public interface DaoCompte {
	public Compte save(Compte cpt); //create or update selon numero null ou pas
	public Compte findById(Long numero);
	public List<Compte> findAll();
	public void deleteById(Long numero);
	//...
	
}
