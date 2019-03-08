package com.m2i.tp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Commande;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceCommande;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/commande" , headers="Accept=application/json")
@CrossOrigin(origins = "*")
public class CommandeRestCtrl {
	
	@Autowired
	private ServiceCommande serviceCommande;
	
	public CommandeRestCtrl() {
	}
	
	
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/commande/1
	@RequestMapping(value="/{numCmde}" , method=RequestMethod.GET)
	public ResponseEntity<Commande> getCommandeByNum(@PathVariable("numCmde")  Long numero){
		Commande cmde = serviceCommande.rechercherCommandeParNumero(numero);
		if(cmde!=null)
			return new ResponseEntity<Commande>(cmde,HttpStatus.OK);
		else 
			return new ResponseEntity<Commande>(HttpStatus.NOT_FOUND);
	}
	

}
