package com.m2i.tp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Client;
import com.m2i.tp.service.ServiceClient;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/client" , headers="Accept=application/json")
public class ClientRestCtrl {
	
	@Autowired
	private ServiceClient serviceClient;
	
	public ClientRestCtrl() {
	}
	
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client/1
	@RequestMapping(value="/{idClient}" , method=RequestMethod.GET)
	public ResponseEntity<Client> getProduitById(@PathVariable("idClient")  Long id){
		Client c = serviceClient.ClientSelonId(id);
		if(c!=null)
			return new ResponseEntity<Client>(c,HttpStatus.OK);
		else 
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client/1
	//@RequestMapping(value="/{idClient}" , method=RequestMethod.DELETE)
	@DeleteMapping("/{idClient}")
	public void deleteClientById(@PathVariable("idClient")  Long id){
		serviceClient.supprimerClient(id);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client?nom=A.*
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Client> getClientsByCriteria(
			@RequestParam(name="nom",required=false) String debutNom){
		List<Client> listeClient = null;
		if(debutNom!=null) {
			if(debutNom.endsWith(".*")) {
				//regex
				debutNom = debutNom.substring(0,debutNom.length()-2);
			}
			if(debutNom.endsWith("*")) {
				//glob
				debutNom = debutNom.substring(0,debutNom.length()-1);
			}
			listeClient = serviceClient.ClientsSelonDebutNom(debutNom);
		}else {
			listeClient = serviceClient.tousClients();
		}
		return listeClient;
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client en POST
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Client saveOrUpdateClient(@RequestBody Client c) {
		//l'annotation @RequestBody permet de récupérer les données (json)
		//véhiculées en mode POST dans la partie invisible "body" de la requête HTTP
		//et effectue automatiquement la conversion "json--> java"
		System.out.println("saveOrUpdateClient , c = " + c);
		serviceClient.sauvegarderClient(c);
		return c;
	}
	

}
