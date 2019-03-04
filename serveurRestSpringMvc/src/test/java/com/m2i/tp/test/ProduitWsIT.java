package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.m2i.tp.entity.Produit;

public class ProduitWsIT {
	private static Logger logger = LoggerFactory.getLogger(ProduitWsIT.class);
	
	private static RestTemplate restTemplate; //objet technique de Spring pour test WS REST
	private static String baseURL;
	private static String serverName;
	
	//pas de @Autowired ni de @RunWith
	//car ce test EXTERNE est censé tester le WebService sans connaître sa structure interne
	// (test BOITE_NOIRE)
	@BeforeClass
	public static void init(){
	   restTemplate = new RestTemplate();
	   serverName="localhost";
	   //serverName="172.28.10.81"; //poste didier/formateur
	   baseURL="http://"+serverName+":8080/serveurRestSpringMvc/rest/produit";
	}
	
	@Test
	public void testGetProduitByNumero() {
		final String uri = baseURL + "/1";
		String resultAsJsonString = restTemplate.getForObject(uri, String.class);
		logger.info("json string of produit 1 via rest: " + resultAsJsonString);
		Produit p1 = restTemplate.getForObject(uri, Produit.class);
		logger.info("produit 1 via rest: " + p1);
		Assert.assertTrue(p1.getNumero()==1L);
	}
	
	@Test
	public void testGetProduitsPasChers() {
		final String uri = baseURL + "?prixMaxi=40";
		Produit[] tabProduits = restTemplate.getForObject(uri, Produit[].class);
		for(Produit prod : tabProduits) {
		     Assert.assertTrue(prod.getPrix()<=40);
		     logger.info("produit entre 0 et 40 euros : " + prod);
		}
	}
	
	@Test
	public void testAjoutProduit(){
	//post/envoi:
	Produit nouveauProduit = new Produit(null,"nouveau produit que j'aime" , 1.2345);

	Produit savedProduct =restTemplate.postForObject(baseURL, nouveauProduit, Produit.class);
	logger.info("savedProduct via rest: " + savedProduct.toString());
	Assert.assertNotNull(savedProduct.getNumero());
	}
	
}
