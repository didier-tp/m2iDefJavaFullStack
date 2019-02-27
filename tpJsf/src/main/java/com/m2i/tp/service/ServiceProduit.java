package com.m2i.tp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.m2i.tp.entity.Compte;
import com.m2i.tp.entity.Produit;

/* interface + classe ou classe direct */
public class ServiceProduit {
    //code interne quelquefois basé un ou plusieurs dao
	//ici (en tp) simulation sans base de données
	
	//Singleton:
	private static ServiceProduit uniqueInstance = null;
	public static ServiceProduit getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new ServiceProduit();
		}
		return uniqueInstance;
	}
	
	private Map<Long,List<Produit>> mapNumCatListProd = new HashMap<>();
	
	private ServiceProduit() {
		//constructeur par defaut (avec jeux de données):
		List<Produit> listeProd1 = new ArrayList<>();
		listeProd1.add(new Produit(1L,"livre 1" , 22.0));
		listeProd1.add(new Produit(2L,"livre 2" , 20.0));
		listeProd1.add(new Produit(3L,"livre 3" , 15.0));
		mapNumCatListProd.put(1L,listeProd1);
		
		List<Produit> listeProd2 = new ArrayList<>();
		listeProd2.add(new Produit(11L,"DVD 1" , 12.0));
		listeProd2.add(new Produit(12L,"DVD 2" , 18.0));
		listeProd2.add(new Produit(13L,"DVD 3" , 6.0));
		mapNumCatListProd.put(2L,listeProd2);
	}
	
	public List<Produit> produitsSelonCategorie(Long numCategorie){
		return mapNumCatListProd.get(numCategorie);
	}
	
	
	
}
