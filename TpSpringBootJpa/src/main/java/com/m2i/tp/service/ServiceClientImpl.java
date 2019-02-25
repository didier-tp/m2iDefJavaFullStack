package com.m2i.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoClient;
import com.m2i.tp.entity.Client;


@Service //héritant de @Component
@Transactional
public class ServiceClientImpl implements ServiceClient {
	
	
	@Autowired
	private DaoClient daoClient; //dao vers lequel déléguer
	
	
	
	//@Autowired
	//private DaoCompte daoCompte; //dao vers lequel déléguer
	

	@Override
	public Client rechercherClientParNumero(Long numero) {
		return daoClient.findById(numero);/*.orElse(null);*/
	}

	@Override
	public void saveOrUpdateClient(Client cpt) {
			daoClient.save(cpt);
	}

	@Override
	public void supprimerClient(Long numClient) {
		daoClient.deleteById(numClient);
	}

	
	
}
