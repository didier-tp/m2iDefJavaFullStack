package com.m2i.tp.rest;

import java.util.ArrayList;
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

import com.m2i.tp.dto.Conversion;
import com.m2i.tp.entity.Devise;
import com.m2i.tp.service.ServiceDevise;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/devise" , headers="Accept=application/json")
//@CrossOrigin(origins = "*")
public class DeviseRestCtrl {
	
	@Autowired
	private ServiceDevise serviceDevise;
	
	public DeviseRestCtrl() {
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise/conversion?montant=100&source=EUR&cible=USD
	@RequestMapping(value="/conversion" , method=RequestMethod.GET)
	public Conversion convertir(
			@RequestParam(name="montant",required=false)Double montant,
			@RequestParam(name="source",required=false)String codeMonnaieSource,
			@RequestParam(name="cible",required=false)String codeMonnaieCible){
		double resConv = serviceDevise.convertir(montant, codeMonnaieSource, codeMonnaieCible);
		return new Conversion(montant, codeMonnaieSource, codeMonnaieCible,resConv);
	}
	
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise/EUR
	@RequestMapping(value="/{codeDevise}" , method=RequestMethod.GET)
	public ResponseEntity<Devise> getProduitByNum(@PathVariable("codeDevise")  String codeDevise){
		Devise d = serviceDevise.rechercherDeviseParCode(codeDevise);
		if(d!=null)
			return new ResponseEntity<Devise>(d,HttpStatus.OK);
		else 
			return new ResponseEntity<Devise>(HttpStatus.NOT_FOUND);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise/EUR
	//@RequestMapping(value="/{numProd}" , method=RequestMethod.DELETE)
	@DeleteMapping("/{codeDevise}")
	public void deleteProduitByNum(@PathVariable("codeDevise")  String codeDevise){
		serviceDevise.supprimerDevise(codeDevise);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise?nom=euro
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Devise> getProduitsByCriteria(
			@RequestParam(name="nom",required=false)String nomDevise){
		List<Devise> listeDevise = null;
		if(nomDevise!=null) {
			listeDevise = new ArrayList<>();
			listeDevise.add(serviceDevise.rechercherDeviseParNom(nomDevise));
		}else {
			listeDevise=serviceDevise.rechercherToutesDevises();
		}
		return listeDevise;
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise en POST
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Devise saveNewDevise(@RequestBody Devise d) {
		//l'annotation @RequestBody permet de récupérer les données (json)
		//véhiculées en mode POST dans la partie invisible "body" de la requête HTTP
		//et effectue automatiquement la conversion "json--> java"
		System.out.println("saveOrUpdateDevise , d = " + d);
		serviceDevise.creerDevise(d);
		return d;
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/devise en PUT
	@RequestMapping(value="" , method=RequestMethod.PUT)
	public Devise updateDevise(@RequestBody Devise d) {
			//l'annotation @RequestBody permet de récupérer les données (json)
			//véhiculées en mode POST dans la partie invisible "body" de la requête HTTP
			//et effectue automatiquement la conversion "json--> java"
			System.out.println("updateDevise , d = " + d);
			serviceDevise.modifierDevise(d);
			return d;
		}
	

}
