package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoCompte;
import com.m2i.tp.entity.Compte;

@Service //@Service hérite de @Component 
@Transactional
public class ServiceCompteImpl implements ServiceCompte {
	
	@Autowired
	private DaoCompte daoCompte;

	@Override
	public Compte rechercherCompteParNumero(Long numero) {
		return daoCompte.findById(numero);
	}
	
	@Override
	public void sauvegarder(Compte c) {
		daoCompte.save(c);
	}

	@Override
	public List<Compte> comptesDuClient() {
		// version temporaire de tp (ameliorable)
		return daoCompte.findAll();
	}

	@Override
	public void virement(double montant, long numCptDeb, long numCptCred) {
		Compte cptDeb = daoCompte.findById(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		daoCompte.save(cptDeb); //appel à .save() facultatif si persistant

		Compte cptCred = daoCompte.findById(numCptCred);
		cptCred.setSolde(cptCred.getSolde() + montant);
		daoCompte.save(cptCred);//appel à .save() facultatif si persistant
	}

	@Override
	public void supprimerCompte(Long numero) {
		daoCompte.deleteById(numero);
	}

	

}
