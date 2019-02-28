package com.m2i.tp.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.m2i.tp.service.Convertisseur;
import com.m2i.tp.service.ConvertisseurImplService;

public class ClientSoapApp {

	public static void main(String[] args) {
		//172.28.10.81 , 172.28.10.163
		//String sUrl = "http://172.28.10.173:8080/serveurSoap/convertisseur?wsdl";
		//String sUrl = "http://172.28.11.67:8080/serveurSoap/convertisseur?wsdl";
		String sUrl = "http://localhost:8080/serveurSoap/convertisseur?wsdl";
	  //String sUrl = "http://formation17:8080/serveurSoap/convertisseur?wsdl";
	  URL wsdlURL = null;
	  try {
		wsdlURL=new URL(sUrl);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
	  //ce code d'appel (coté client) s'appuie sur le code généré par wsimport:
      // toujours (new ....Service()).get....Port() pour récupérer une instance
	  // de l'intermédiaire local (proxy) qui délègue les appels au coté serveur
	  Convertisseur proxyWsConv =	(new ConvertisseurImplService(wsdlURL))
			                                .getConvertisseurImplPort();
	  String auteur = proxyWsConv.getAuteur();
	  System.out.println("auteur="+auteur);
	  double sF = proxyWsConv.euroToFranc(15.0);
	  System.out.println("15 euros = " + sF +  " francs");
	}

}
