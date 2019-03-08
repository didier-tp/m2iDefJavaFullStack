package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoClient;
import com.m2i.tp.dao.DaoCommande;
import com.m2i.tp.dao.DaoProduit;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Commande;
import com.m2i.tp.entity.Produit;

@Service
@Transactional
public class ServiceCommandeImpl implements ServiceCommande {
	
	@Autowired
	private DaoCommande daoCommande;
	
	@Autowired
	private DaoClient daoClient;
	
	@Autowired
	private DaoProduit daoProduit;
	

	@Override
	public Commande creerCommande(Long numClient, List<Produit> listeProd) {
		Client client = daoClient.findById(numClient).get();
		Commande commande = new Commande(); //with numCommande=null avant insert/auto_incr
		commande.setClient(client);
		commande.setProduits(listeProd);
		daoCommande.save(commande);
		return commande;
	}

	@Override
	public Commande rechercherCommandeParNumero(Long numCommande) {
		Commande cmde =  daoCommande.findById(numCommande).orElse(null);
		LazyLoadingUtil.loadImmediatlyLazyCollection(cmde.getProduits());
		return cmde;
	}

	@Override
	public List<Commande> rechercherCommandesPourClient(Long numClient) {
		return daoCommande.findCommandeByClientId(numClient);
	}

}
