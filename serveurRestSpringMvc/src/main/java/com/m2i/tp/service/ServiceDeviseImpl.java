package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoDevise;
import com.m2i.tp.entity.Devise;

@Service
@Transactional
public class ServiceDeviseImpl implements ServiceDevise {
	
	@Autowired
	private DaoDevise daoDevise;

	@Override
	public double convertir(double montant, String codeMonnaieSource, String codeMonnaieCible) {
		double resConv=0;
		Devise deviseSource = daoDevise.findById(codeMonnaieSource).get();
		Devise deviseCible = daoDevise.findById(codeMonnaieCible).get();
		resConv = montant * deviseCible.getDChange() / deviseSource.getDChange();
		return resConv;
	}

	@Override
	public Devise rechercherDeviseParCode(String codeDevise) {
		return daoDevise.findById(codeDevise).orElse(null);
	}

	@Override
	public Devise rechercherDeviseParNom(String nomDevise) {
		return daoDevise.findByNom(nomDevise);
	}

	@Override
	public void creerDevise(Devise nouvelleDevise) {
		if(daoDevise.existsById(nouvelleDevise.getCode())) {
			throw new MyServiceException("une devise existante a deja le code suivant:" + nouvelleDevise.getCode());
		}
		daoDevise.save(nouvelleDevise);
	}

	@Override
	public void modifierDevise(Devise deviseExistante) {
		if(!daoDevise.existsById(deviseExistante.getCode())) {
			throw new MyServiceException("aucune devise existe avec le code suivant:" + deviseExistante.getCode());
		}
		daoDevise.save(deviseExistante);
	}

	@Override
	public void supprimerDevise(String codeDeviseExistante) {
		daoDevise.deleteById(codeDeviseExistante);
	}

	@Override
	public List<Devise> rechercherToutesDevises() throws MyServiceException {
		return (List<Devise>) daoDevise.findAll();
	}

}
