package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoClient;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Produit;
@Service
@Transactional
public class ServiceClientImpl implements ServiceClient {
	
	@Autowired
	private DaoClient daoClient;

	@Override
	public Client ClientSelonId(Long idClient) {
		return daoClient.findById(idClient).orElse(null);
	}

	@Override
	public void sauvegarderClient(Client c) {
		daoClient.save(c);

	}

	@Override
	public void supprimerClient(Long numClient) {
		daoClient.deleteById(numClient);
	}

	@Override
	public List<Client> tousClients() {
		return (List<Client>) daoClient.findAll();
	}

	@Override
	public List<Client> ClientsSelonDebutNom(String debutNom) {
		return daoClient.findByNomStartingWith(debutNom);
	}

}
