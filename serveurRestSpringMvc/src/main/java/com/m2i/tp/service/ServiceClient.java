package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Client;

public interface ServiceClient {
	public Client ClientSelonId(Long idClient);
	public void sauvegarderClient(Client c);
	public void supprimerClient(Long numClient);
	public List<Client> tousClients();
	public List<Client> ClientsSelonDebutNom(String debutNom);
	
}
