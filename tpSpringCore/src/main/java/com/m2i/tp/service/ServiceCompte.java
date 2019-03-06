package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Compte;

public interface ServiceCompte {
	Compte rechercherCompteParNumero(Long numero);
	List<Compte> comptesDuClient(); //avec numClient par defaut (pour tpJsf)
	//List<Compte> comptesDuClient(Long numClient);
	void virement(double montant,long numCptDeb,long numCptCred);
	void supprimerCompte(Long numero);
	void sauvegarder(Compte c);//create or update
	//...
}
