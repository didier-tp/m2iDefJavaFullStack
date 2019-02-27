package com.m2i.tp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.m2i.tp.entity.Compte;

/* interface + classe ou classe direct */
public class ServiceCompte {
    //code interne quelquefois basé un ou plusieurs dao
	//ici (en tp) simulation sans base de données
	
	//Singleton:
	private static ServiceCompte uniqueInstance = null;
	public static ServiceCompte getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new ServiceCompte();
		}
		return uniqueInstance;
	}
	
	private Map<Long,Compte> mapComptes = new HashMap<>();
	
	public ServiceCompte() {
		//constructeur par defaut (avec jeux de données):
		mapComptes.put(1L,new Compte(1L,"compte 1", 110.0));
		mapComptes.put(2L,new Compte(2L,"compte 2", 220.0));
		mapComptes.put(3L,new Compte(3L,"compte 3", 330.0));
	}
	
	public List<Compte> comptesDuClient(){
		return new ArrayList<Compte>(mapComptes.values());
	}
	
	public void virement(Double montant,Long numCptDeb,Long numCptCred) {
		Compte cptDeb= mapComptes.get(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde()-montant);
		
		Compte cptCred= mapComptes.get(numCptCred);
		cptCred.setSolde(cptCred.getSolde()+montant);
	}
	
}
