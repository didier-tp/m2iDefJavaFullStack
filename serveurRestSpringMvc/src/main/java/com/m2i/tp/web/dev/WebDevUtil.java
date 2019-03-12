package com.m2i.tp.web.dev;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.m2i.tp.entity.Adresse;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Commande;
import com.m2i.tp.entity.Devise;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceClient;
import com.m2i.tp.service.ServiceCommande;
import com.m2i.tp.service.ServiceDevise;
import com.m2i.tp.service.ServiceProduit;

@Component
@Profile("web.dev")
public class WebDevUtil {
	
	@Autowired
	private ServiceClient serviceClient;
	
	@Autowired
	private ServiceProduit serviceProduit;
	
	@Autowired
	private ServiceCommande serviceCommande;
	
	@Autowired
	private ServiceDevise serviceDevise;
	
	@PostConstruct
	public void initJeuxDonneesEnDebutDeDeveloppement() {
		Devise d1 = new Devise("EUR","euro",0.9); serviceDevise.creerDevise(d1);
		Devise d2 = new Devise("USD","dollar",1.0); serviceDevise.creerDevise(d2);
		Devise d3 = new Devise("GBP","livre",0.8); serviceDevise.creerDevise(d3);
		Devise d4 = new Devise("JPY","yen",123.2); serviceDevise.creerDevise(d4);
		
		Produit pA1 = new Produit(null,"pA1",51.0);	serviceProduit.sauvegarderProduit(pA1);
		Produit pB1 = new Produit(null,"pB1",21.0);	serviceProduit.sauvegarderProduit(pB1);
		Produit pC1 = new Produit(null,"pC1",501.0);serviceProduit.sauvegarderProduit(pC1);
		
		Client c1 = new Client(1L,"Bon","jean" ,"jean.bon@labas.fr" , "010203040506");
		c1.setAdresse(new Adresse("12, rue Elle" , "75001" , "Paris"));
		serviceClient.sauvegarderClient(c1);
		Client c2 = new Client(2L,"Therieur","alain" ,"alain.therieur@ici.fr" , "0605040201");
		c2.setAdresse(new Adresse("14, impasse xy" , "80000" , "Amiens"));
		serviceClient.sauvegarderClient(c2);
		Client c3 = new Client(3L,"Condor","olie" ,"olie.condor@au-lit.fr" , "063030201");
		c3.setAdresse(new Adresse("13, rue jeanne d'arc" , "76000" , "Rouen"));
		serviceClient.sauvegarderClient(c3);
		
		List<Produit> panierProduitsDeC1= new ArrayList<>();
		panierProduitsDeC1.add(pA1); panierProduitsDeC1.add(pB1);
		Commande cmde1 = serviceCommande.creerCommande(c1.getId(), panierProduitsDeC1);
	}
}
