package com.m2i.tp.web.dev;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.m2i.tp.entity.Adresse;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceClient;
import com.m2i.tp.service.ServiceProduit;

@Component
@Profile("web.dev")
public class WebDevUtil {
	
	@Autowired
	private ServiceClient serviceClient;
	
	@Autowired
	private ServiceProduit serviceProduit;
	
	@PostConstruct
	public void initJeuxDonneesEnDebutDeDeveloppement() {
		
		serviceProduit.sauvegarderProduit(new Produit(1L,"produit 1 de didier" , 29.0));
		serviceProduit.sauvegarderProduit(new Produit(2L,"produit 2 de didier" , 56.0));
		serviceProduit.sauvegarderProduit( new Produit(3L,"produit 3 de didier" , 28.0));
		
		Client c1 = new Client(1L,"Bon","jean" ,"jean.bon@labas.fr" , "010203040506");
		c1.setAdresse(new Adresse("12, rue Elle" , "75001" , "Paris"));
		serviceClient.sauvegarderClient(c1);
		Client c2 = new Client(2L,"Therieur","alain" ,"alain.therieur@ici.fr" , "0605040201");
		c2.setAdresse(new Adresse("14, impasse xy" , "80000" , "Amiens"));
		serviceClient.sauvegarderClient(c2);
		Client c3 = new Client(3L,"Condor","olie" ,"olie.condor@au-lit.fr" , "063030201");
		c3.setAdresse(new Adresse("13, rue jeanne d'arc" , "76000" , "Rouen"));
		serviceClient.sauvegarderClient(c3);
	}
}
