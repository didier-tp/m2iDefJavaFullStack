package com.m2i.tp.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.dto.Promo;
import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceProduit;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/produit" , headers="Accept=application/json")
@CrossOrigin(origins = "*")
public class ProduitRestCtrl {
	
	@Autowired
	private ServiceProduit serviceProduit;
	
	public ProduitRestCtrl() {
		//temporairement (en debut de phase de developpement)
		serviceProduit.sauvegarderProduit(new Produit(1L,"produit 1 de didier" , 29.0));
		serviceProduit.sauvegarderProduit(new Produit(2L,"produit 2 de didier" , 56.0));
		serviceProduit.sauvegarderProduit( new Produit(3L,"produit 3 de didier" , 28.0));
	}
	
	private void appliquerPromo(double tauxReductionPct) {
		Collection<Produit> collectionProd = serviceProduit.tousProduits();
		for(Produit prod : collectionProd) {
			//prod est ici un objet à l'état détaché
			prod.setPrix(prod.getPrix() * (1 - tauxReductionPct/100) );
			serviceProduit.sauvegarderProduit(prod);
		}
	}
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit/promo
	//avec { "tauxReductionPct" : 5.0 } comme promo en json (POST)
	@PostMapping("/promo")
	public ResponseEntity<Promo> postPromo(@RequestBody Promo promo) {
		try {
			appliquerPromo(promo.getTauxReductionPct());
			return new ResponseEntity<Promo>(promo,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Promo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit/1
	@RequestMapping(value="/{numProd}" , method=RequestMethod.GET)
	public ResponseEntity<Produit> getProduitByNum(@PathVariable("numProd")  Long numero){
		Produit p = serviceProduit.produitSelonNumero(numero);
		if(p!=null)
			return new ResponseEntity<Produit>(p,HttpStatus.OK);
		else 
			return new ResponseEntity<Produit>(HttpStatus.NOT_FOUND);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit/1
	//@RequestMapping(value="/{numProd}" , method=RequestMethod.DELETE)
	@DeleteMapping("/{numProd}")
	public void deleteProduitByNum(@PathVariable("numProd")  Long numero){
		serviceProduit.supprimerProduit(numero);
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit?prixMaxi=40
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Produit> getProduitsByCriteria(
			@RequestParam(name="prixMaxi",required=false)Double prixMaxi){
		List<Produit> listeProd = null;
		if(prixMaxi!=null) {
			listeProd=serviceProduit.produitsPasChers(prixMaxi);
		}else {
			listeProd=serviceProduit.tousProduits();
		}
		return listeProd;
	}
	
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/produit en POST
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Produit saveOrUpdateProduit(@RequestBody Produit p) {
		//l'annotation @RequestBody permet de récupérer les données (json)
		//véhiculées en mode POST dans la partie invisible "body" de la requête HTTP
		//et effectue automatiquement la conversion "json--> java"
		System.out.println("saveOrUpdateProduit , p = " + p);
		serviceProduit.sauvegarderProduit(p);
		return p;
	}
	

}
