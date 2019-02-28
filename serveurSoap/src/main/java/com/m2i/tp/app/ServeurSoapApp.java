package com.m2i.tp.app;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import com.m2i.tp.service.ConvertisseurImpl;

public class ServeurSoapApp {
	
	public ServeurSoapApp() {
		System.out.println("démarrage du serveur ...");
		ConvertisseurImpl wsImpl = new ConvertisseurImpl();
		String myHostName = "localhost";
		try {
			//myHostName= InetAddress.getLocalHost().getHostName(); //nom ordi
			myHostName= InetAddress.getLocalHost().getHostAddress();//adresse ip
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String wsUrl = "http://"+myHostName+":8080/serveurSoap/convertisseur";
		//NB: l'adresse ip très spéciale 0.0.0.0 permet au serveur lancé
		//d'accepter des requêtes provenant d'autres machines
		String wsUrlTp = "http://0.0.0.0:8080/serveurSoap/convertisseur";
		System.out.println("wsUrl soap=" + wsUrl);
		System.out.println("wsUrl wsdl=" + wsUrl+"?wsdl");
		//Endpoint.publish() de la machine virtuelle java (>=1.6)
		//va démarrer un mini serveur java/web (ex: jetty)
		//pour gérer le webservice
		//la description WSDL sera générée automatiquement
		//et sera accessible au bout de l'url wsUrl suffixée par ?wsdl
		//Une tâche de fond attend les requetes "soap" 
		//et y répond automatiquement
		Endpoint.publish(wsUrlTp, wsImpl);
	}

	public static void main(String[] args) {
		new ServeurSoapApp(); System.out.println("Server ready...");
			try {
				Thread.sleep(15 * 60 * 1000);// 15 minutes
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Server exiting"); 
		System.exit(0); //System.exit(0) permet de bien tout arrêter proprement
	}

}
