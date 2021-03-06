package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Client;

public interface ClientService {
	
	Client rechercherClientParNum(Long num);
	List<Client> rechercherTousClients();
	List<Client> rechercherClientsParRole(String role);
	Client sauvegarderClient(Client c);
	void supprimerClient(Long numero);
	//...

}
