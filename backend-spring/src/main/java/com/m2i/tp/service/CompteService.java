package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Compte;

public interface CompteService {
	Compte rechercherCompteParNum(Long num);
	List<Compte> rechercherTousComptes();
	Compte sauvegarderCompte(Compte c);
	void supprimerCompte(Long numero);
	//...
	void transferer(double montant,long numCptDeb, long numCptCred);
	List<Compte> rechercherComptesDuClient(long numClient);
}
