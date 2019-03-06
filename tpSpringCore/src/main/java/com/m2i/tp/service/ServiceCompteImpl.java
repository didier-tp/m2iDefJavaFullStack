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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void virement(double montant, long numCptDeb, long numCptCred) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCompte(Long numero) {
		// TODO Auto-generated method stub

	}

	

}
