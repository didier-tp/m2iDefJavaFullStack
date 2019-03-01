package com.m2i.tp.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Produit;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/produit" , headers="Accept=application/json")
public class ProduitRestCtrl {
	
	private Map<Long,Produit> mapProduits = new HashMap<>();
	
	public ProduitRestCtrl() {
		mapProduits.put(1L, new Produit(1L,"produit 1" , 12.0));
		mapProduits.put(2L, new Produit(2L,"produit 2" , 56.0));
		mapProduits.put(3L, new Produit(3L,"produit 3" , 28.0));
	}
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit/1
	@RequestMapping(value="/{numProd}" , method=RequestMethod.GET)
	public Produit getProduitByNum(@PathVariable("numProd")  Long numero){
		return mapProduits.get(numero);
	}

}
