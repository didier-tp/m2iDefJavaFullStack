package com.m2i.tp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Client;
import com.m2i.tp.service.ClientService;

@RestController //hérite de @Component
@RequestMapping(value="/rest/client" , headers="Accept=application/json")
public class ClientRestCtrl {
	
	
	@Autowired
	private ClientService clientService;
	
	
	
	//http://localhost:8080/backend-spring/rest/client/1_ou_2
	@RequestMapping(value="/{numClient}" , method=RequestMethod.GET)
	public Client getClientByNum(@PathVariable("numClient")Long numCli) {
		return clientService.rechercherClientParNum(numCli);		
	}
	
	//http://localhost:8080/backend-spring/rest/client
	//http://localhost:8080/backend-spring/rest/client?role=admin
	//http://localhost:8080/backend-spring/rest/client?role=admin&p2=v2
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Client> getClientsByCriteria(
			@RequestParam(name="role",required=false) String role) {
		if(role==null)
		    return clientService.rechercherTousClients();
		else
			return clientService.rechercherClientsParRole(role);
	}

}
