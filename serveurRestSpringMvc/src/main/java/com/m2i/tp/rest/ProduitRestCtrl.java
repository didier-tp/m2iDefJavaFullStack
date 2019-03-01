package com.m2i.tp.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Produit;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/produit" , headers="Accept=application/json")
public class ProduitRestCtrl {
	
	Produit getProduitByNum(Long numero){
		return null;
	}

}
