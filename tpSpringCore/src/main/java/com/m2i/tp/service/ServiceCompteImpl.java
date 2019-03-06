package com.m2i.tp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoCompte;
import com.m2i.tp.entity.Compte;

@Service //@Service hérite de @Component 
@Transactional
public class ServiceCompteImpl implements ServiceCompte {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceCompteImpl.class);
	
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
	
	//regle métier / règle de gestion
	public void verifierDebitFaisable(Compte cpt,double montant) {
		if( !(cpt.getSolde()>=montant) )
			//throw new RuntimeException("pas assez argent, pov con");
			throw new RuntimeException("solde insuffisant");
			
	}

	@Override
	//@Transactional ici ou bien au dessus de la classe entière du Service
	public void virement(double montant, long numCptDeb, long numCptCred) {
		//dès le début de l'execution de cette méthode (améliorée par spring)
		//il y a initialisation automatique de entityManager et transaction
		try {
			Compte cptDeb = daoCompte.findById(numCptDeb);
			verifierDebitFaisable(cptDeb,montant);
			cptDeb.setSolde(cptDeb.getSolde() - montant);
			//daoCompte.save(cptDeb); //appel à .save() facultatif si persistant

			Compte cptCred = daoCompte.findById(numCptCred);
			cptCred.setSolde(cptCred.getSolde() + montant);
			//daoCompte.save(cptCred);//appel à .save() facultatif si persistant
		} catch (Exception e) {
			logger.error("echec virement",e.getMessage() /* ou e */); //pour aider le debug via fichier de log
			throw new RuntimeException("echec virement",e);//pour indirectement remonter
			                //un message d'erreur à l'utilisateur
		}
		//en fin de méthode (améliorée par Spring)
		//commit automatique si pas de exception et les mécanismes automatiques
		//de Jpa/hibernate font que commit() déclenche flush() 
		//pour sauvegarder en base tous les objets persistants modifiés en mémoire
	}

	@Override
	public void supprimerCompte(Long numero) {
		daoCompte.deleteById(numero);
	}

	

}
