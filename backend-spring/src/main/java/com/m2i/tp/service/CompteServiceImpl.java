package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.CompteDao;
import com.m2i.tp.entity.Compte;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CompteServiceImpl implements CompteService {
	
	
	@Autowired
	private CompteDao compteDao;

	@Override
	public Compte rechercherCompteParNum(Long num) {
		//return compteDao.findById(num).get(); //avec eventuelle exception
		return compteDao.findById(num).orElse(null);
	}

	@Override
	public List<Compte> rechercherTousComptes() {
		return (List<Compte>) compteDao.findAll();
	}

	@Override
	public Compte sauvegarderCompte(Compte c) {
		return compteDao.save(c);
	}

	@Override
	public void supprimerCompte(Long numero) {
		compteDao.deleteById(numero);
	}

	@Override
	public void transferer(double montant, long numCptDeb, long numCptCred) {
		Compte cptDeb = compteDao.findById(numCptDeb).get();
		cptDeb.setSolde(cptDeb.getSolde()-montant);
		//compteDao.save(cptDeb); //automatique si contexte @Transactional
		
		Compte cptCred = compteDao.findById(numCptCred).get();
		cptCred.setSolde(cptCred.getSolde()+montant);
		//compteDao.save(cptCred); //automatique si contexte @Transactional
		
	}

	@Override
	public List<Compte> rechercherComptesDuClient(long numClient) {
		// avec version codée avec @OneToMany et @NamedQuery
		//return compteDao.findByClientNum(numClient);
		
		// avec version codée automatiquement via convention de noms
		return compteDao.findByClientNumero(numClient);
	}

}
