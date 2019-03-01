package com.m2i.tp.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Produit;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/produit" , headers="Accept=application/json")
public class ProduitRestCtrl {
	
	private Map<Long,Produit> mapProduits = new HashMap<>();
	private Long numMax = null; //pour simuler auto_increment
	
	public ProduitRestCtrl() {
		mapProduits.put(1L, new Produit(1L,"produit 1" , 12.0));
		mapProduits.put(2L, new Produit(2L,"produit 2" , 56.0));
		mapProduits.put(3L, new Produit(3L,"produit 3" , 28.0));
		numMax=3L;
	}
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit/1
	@RequestMapping(value="/{numProd}" , method=RequestMethod.GET)
	public Produit getProduitByNum(@PathVariable("numProd")  Long numero){
		return mapProduits.get(numero);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit?prixMaxi=40
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Produit> getProduitsByCriteria(
			@RequestParam(name="prixMaxi",required=false)Double prixMaxi){
		List<Produit> listeProd = new ArrayList<>(mapProduits.values());
		if(prixMaxi!=null) {
			/*
			for(int i=listeProd.size()-1;i>=0;i--) {
				Produit p = listeProd.get(i);
				if(p.getPrix()>prixMaxi) {
					listeProd.remove(p);
				}
			}*/
			listeProd = listeProd.stream()
					  .map((p)->{ p.setLabel(p.getLabel().toUpperCase()); return p;})
			          .filter( (p)-> p.getPrix()<prixMaxi )
			          .collect(Collectors.toList());
		}
		return listeProd;
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit en POST
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Produit saveOrUpdateProduit(@RequestBody Produit p) {
		//l'annotation @RequestBody permet de récupérer les données (json)
		//véhiculées en mode POST dans la partie invisible "body" de la requête HTTP
		//et effectue automatiquement la conversion "json--> java"
		if(p.getNumero()==null) {
			  this.numMax++;
			  p.setNumero(numMax);
		}
		mapProduits.put(p.getNumero(), p);
		return p;
	}
	

}
