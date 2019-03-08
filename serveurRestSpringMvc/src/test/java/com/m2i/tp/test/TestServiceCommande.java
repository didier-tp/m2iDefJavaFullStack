package com.m2i.tp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.MySpringBootApplication;
import com.m2i.tp.entity.Adresse;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Commande;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceClient;
import com.m2i.tp.service.ServiceCommande;
import com.m2i.tp.service.ServiceProduit;



//Test unitaire du service métier "ServiceProduit"

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceCommande {
	
	@Autowired
	private ServiceCommande serviceCommande; //à tester
	
	@Autowired
	private ServiceClient serviceClient; //annexe
	
	@Autowired
	private ServiceProduit serviceProduit; //annexe
	
	private void afficherCommandeDetaillee(Commande c) {
		System.out.print("numCommande="+c.getNumCommande());
		System.out.print(" passee par  "+ c.getClient());
		System.out.println(" avec produits = "+ c.getProduits());
	}
	
	private void afficherCommandeSansListeDesProduits(Commande c) {
		System.out.print("numCommande="+c.getNumCommande());
		System.out.println(" passee par  "+ c.getClient());
	}
	
	@Test
	public void testEssentielCommande() {
		
		Produit pA1 = new Produit(null,"pA1",51.0);	serviceProduit.sauvegarderProduit(pA1);
		Produit pB1 = new Produit(null,"pB1",21.0);	serviceProduit.sauvegarderProduit(pB1);
		Produit pC1 = new Produit(null,"pC1",501.0);	serviceProduit.sauvegarderProduit(pC1);
	
		Produit pA2 = new Produit(null,"pA2",52.0);	serviceProduit.sauvegarderProduit(pA2);
		Produit pB2 = new Produit(null,"pB2",22.0);	serviceProduit.sauvegarderProduit(pB2);
		
		Client c1 = new Client(null,"Bon","jean" ,"jean.bon@labas.fr" , "010203040506");
		c1.setAdresse(new Adresse("12, rue Elle" , "75001" , "Paris"));
		serviceClient.sauvegarderClient(c1);
		
		List<Produit> panierProduitsDeC1= new ArrayList<>();
		panierProduitsDeC1.add(pA1); panierProduitsDeC1.add(pB1);
		Commande cmde1 = serviceCommande.creerCommande(c1.getId(), panierProduitsDeC1);
		
		List<Produit> panierProduitsDeC1Bis= new ArrayList<>();
		panierProduitsDeC1Bis.add(pC1); 
		Commande cmde2 = serviceCommande.creerCommande(c1.getId(), panierProduitsDeC1Bis);
		
		Client c2 = new Client(null,"Therieur","alain" ,"alain.therieur@ici.fr" , "0605040201");
		c2.setAdresse(new Adresse("14, impasse xy" , "80000" , "Amiens"));
		serviceClient.sauvegarderClient(c2);
		
		List<Produit> panierProduitsDeC2= new ArrayList<>();
		panierProduitsDeC2.add(pA2); panierProduitsDeC2.add(pB2);
		Commande cmde3 = serviceCommande.creerCommande(c2.getId(), panierProduitsDeC2);
		
		
		Commande cmde3Relue = serviceCommande.rechercherCommandeParNumero(cmde3.getNumCommande());
		System.out.println("cmde3Relue avec details :");
		afficherCommandeDetaillee(cmde3Relue);
		System.out.println("----");
		
		List<Commande> commandesDuClient1 = serviceCommande.rechercherCommandesPourClient(c1.getId());
		System.out.println("commandesDuClient1:");
		for(Commande cmde : commandesDuClient1) {
			//afficherCommandeSansListeDesProduits(cmde);
			Commande cmdeDetaillee = serviceCommande.rechercherCommandeParNumero(cmde.getNumCommande());
			afficherCommandeDetaillee(cmdeDetaillee);
		}
		
		
	}
	
	

}
