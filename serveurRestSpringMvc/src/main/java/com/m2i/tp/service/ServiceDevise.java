package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Devise;

public interface ServiceDevise {
	public double convertir(double montant,
			                String codeMonnaieSource, String codeMonnaieCible) throws MyServiceException;
	public Devise rechercherDeviseParCode(String codeDevise) throws MyServiceException;
	public Devise rechercherDeviseParNom(String nomDevise) throws MyServiceException;
	public List<Devise> rechercherToutesDevises() throws MyServiceException;
	public void creerDevise(Devise nouvelleDevise) throws MyServiceException;
	public void modifierDevise(Devise deviseExistante) throws MyServiceException;
	public void supprimerDevise(String codeDeviseExistante) throws MyServiceException;
}
