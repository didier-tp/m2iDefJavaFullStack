package com.m2i.tp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.dto.AuthResponse;
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
	
	//http://localhost:8080/backend-spring/rest/client en mode POST
	//avec { "username" : "u1" , "password" : "p1" , "roles" : "user" }
	//dans la partie "body" de la requete HTTP.
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Client postClient(@RequestBody Client cli) {
		return clientService.sauvegarderClient(cli);
	}
	
	
	//http://localhost:8080/backend-spring/rest/client/verifAuth en mode POST
	//avec { "username" : "u1" , "password" : "p1" , "roles" : "user" }
	//dans la partie "body" de la requete HTTP.
	@RequestMapping(value="/verifAuth" , method=RequestMethod.POST)
	public AuthResponse verifierAuthClient(@RequestBody Client cli) {
			AuthResponse authResponse = new AuthResponse();
			List<Client> listeCli = clientService.rechercherTousClients();
			for(Client c : listeCli) {
				if(c.getUsername().equals(cli.getUsername())
					&& c.getPassword().equals(cli.getPassword())){
					authResponse.setOk(true);
					authResponse.setMessage("successful login");
					authResponse.setToken("valid_token_jwt_ou_autre");
					return authResponse;
				}
			}
		/*else*/
		authResponse.setOk(false);
		authResponse.setMessage("login failed");
		authResponse.setToken(null);
		return authResponse;	
	}
	
	/*
	//http://localhost:8080/backend-spring/rest/client/1_ou_2 DELETE
	@RequestMapping(value="/{numClient}" , method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteClientByNum(@PathVariable("numClient")Long numCli) {
			try {
				clientService.supprimerClient(numCli);
				return new ResponseEntity<String>("suppression effectuee",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("echec suppression",HttpStatus.NOT_FOUND);
			}		
	}*/
	
	//http://localhost:8080/backend-spring/rest/client/1_ou_2 DELETE
	@RequestMapping(value="/{numClient}" , method=RequestMethod.DELETE)
	public String deleteClientByNum(@PathVariable("numClient")Long numCli) {
			clientService.supprimerClient(numCli);
			return "suppression effectuee"; //si pas d'exception seulement	
			
			//Etant donné que clientService.supprimerClient retourne maintenant
			// NotFoundException préfixée par @ResponseStatus(HttpStatus.NOT_FOUND) 
			
			//En cas d'exception non rattrapée , le framework Spring-mvc
			//retournera automatiquement le bon status d'erreur 404
	}
	

}
