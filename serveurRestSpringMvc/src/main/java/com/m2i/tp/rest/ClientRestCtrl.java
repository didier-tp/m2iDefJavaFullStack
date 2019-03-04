package com.m2i.tp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Adresse;
import com.m2i.tp.entity.Client;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/client" , headers="Accept=application/json")
public class ClientRestCtrl {
	
	private Map<Long,Client> mapClients = new HashMap<>();
	private Long idMax = null; //pour simuler auto_increment
	
	public ClientRestCtrl() {
		Client c1 = new Client(1L,"Bon","jean" ,"jean.bon@labas.fr" , "010203040506");
		c1.setAdresse(new Adresse("12, rue Elle" , "75001" , "Paris"));
		mapClients.put(1L, c1);
		Client c2 = new Client(2L,"Therieur","alain" ,"alain.therieur@ici.fr" , "0605040201");
		c2.setAdresse(new Adresse("14, impasse xy" , "80000" , "Amiens"));
		mapClients.put(2L, c2);
		Client c3 = new Client(3L,"Condor","olie" ,"olie.condor@au-lit.fr" , "063030201");
		c3.setAdresse(new Adresse("13, rue jeanne d'arc" , "76000" , "Rouen"));
		mapClients.put(3L, c3);
		idMax=3L;
	}
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client/1
	@RequestMapping(value="/{idClient}" , method=RequestMethod.GET)
	public ResponseEntity<Client> getProduitById(@PathVariable("idClient")  Long id){
		Client c = mapClients.get(id);
		if(c!=null)
			return new ResponseEntity<Client>(c,HttpStatus.OK);
		else 
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client/1
	//@RequestMapping(value="/{idClient}" , method=RequestMethod.DELETE)
	@DeleteMapping("/{idClient}")
	public void deleteClientById(@PathVariable("idClient")  Long id){
		mapClients.remove(id);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/client?nom=A.*
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Client> getClientsByCriteria(
			@RequestParam(name="nom",required=false) String debutNom){
		List<Client> listeClient = new ArrayList<>(mapClients.values());
		if(debutNom!=null) {
			listeClient = listeClient.stream()
					  .filter( (c)-> c.getNom().matches(debutNom) )
			          .collect(Collectors.toList());
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
		if(c.getId()==null) {
			  this.idMax++;
			  c.setId(idMax);
		}
		mapClients.put(c.getId(), c);
		return c;
	}
	

}
