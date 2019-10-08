package com.m2i.tp.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Client;
import com.m2i.tp.service.ClientService;

@RestController //hérite de @Component
@RequestMapping(value="/rest/client" , headers="Accept=application/json")
public class ClientRestCtrl {
	
	
	@Autowired
	private ClientService clientService;
	
	@PostConstruct //appelée après constrcteur et après injections (paramétrées via autowired)
	private void initJeuxDonneesEnModeDeveloppement() {
		Client c1 = new Client(); c1.setUsername("user1");
		c1.setPassword("pwd1"); c1.setRoles("user,admin");
		clientService.sauvegarderClient(c1);
		
		Client c2 = new Client(); c2.setUsername("user2");
		c2.setPassword("pwd2"); c2.setRoles("user,admin");
		clientService.sauvegarderClient(c2);
	}
	
	//http://localhost:8080/backend-spring/rest/client/1_ou_2
	@RequestMapping(value="/{numClient}" , method=RequestMethod.GET)
	public Client getClientByNum(@PathVariable("numClient")Long numCli) {
		return clientService.rechercherClientParNum(numCli);		
	}
	
	//http://localhost:8080/backend-spring/rest/client
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Client> getAllClients() {
		return clientService.rechercherTousClients();		
	}

}
