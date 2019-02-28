package com.m2i.tp.client;

import com.m2i.tp.service.Convertisseur;
import com.m2i.tp.service.ConvertisseurImplService;

public class ClientSoapApp {

	public static void main(String[] args) {
	  //ce code d'appel (coté client) s'appuie sur le code généré par wsimport:
      // toujours (new ....Service()).get....Port() pour récupérer une instance
	  // de l'intermédiaire local (proxy) qui délègue les appels au coté serveur
	  Convertisseur proxyWsConv =	(new ConvertisseurImplService())
			                                .getConvertisseurImplPort();
	  String auteur = proxyWsConv.getAuteur();
	  System.out.println("auteur="+auteur);
	  double sF = proxyWsConv.euroToFranc(15.0);
	  System.out.println("15 euros = " + sF +  " francs");
	}

}
