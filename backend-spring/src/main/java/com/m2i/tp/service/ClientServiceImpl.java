package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.ClientDao;
import com.m2i.tp.entity.Client;
import com.m2i.tp.exception.NotFoundException;

@Service //héritant de @Component
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public Client rechercherClientParNum(Long num) {
		return clientDao.findById(num);
	}

	@Override
	public List<Client> rechercherTousClients() {
		return clientDao.findAll();
	}

	@Override
	public Client sauvegarderClient(Client c) {
		return clientDao.save(c);
	}

	@Override
	public void supprimerClient(Long numero) {
		try {
			clientDao.deleteById(numero);
		} catch (Exception e) {
			//e.printStackTrace();
			throw new NotFoundException("echec suppression" , e);
		}
	}

	@Override
	public List<Client> rechercherClientsParRole(String role) {
		return clientDao.findByRolesContaining(role);
	}

}
