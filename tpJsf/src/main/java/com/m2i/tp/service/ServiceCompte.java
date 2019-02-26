package com.m2i.tp.service;

import java.util.ArrayList;
import java.util.List;

import com.m2i.tp.entity.Compte;

/* interface + classe ou classe direct */
public class ServiceCompte {
    //code interne quelquefois basé un ou plusieurs dao
	//ici (en tp) simulation sans base de données
	
	public List<Compte> comptesDuClient(){
		List<Compte> listeComptes = new ArrayList<>();
		listeComptes.add(new Compte(1L,"compte 1", 120.0));
		listeComptes.add(new Compte(2L,"compte 2", 220.0));
		return listeComptes;
	}
	
}
