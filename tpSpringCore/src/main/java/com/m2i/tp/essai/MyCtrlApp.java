package com.m2i.tp.essai;

import java.util.Scanner;

public class MyCtrlApp {
	/*
	public void sequenceV1SansPattern() {
		//1 saisir x
		double x;
		Scanner s = new Scanner(System.in);
		System.out.print("x=");
		x=s.nextDouble();
		//2 calculer racine carrée
		double y = Math.sqrt(x);
		//3 afficher le résultat
		System.out.println("y="+y);
	}*/
	
	private Calculateur calculateur=null;
	
	private Afficheur afficheur=null;
	
	
	public void sequence() {
		//on délègue vers sous objets interchangeables 
		//Design pattern STRATEGIE .
		/*
		//calculateur = new CalculateurV1();
		calculateur = new CalculateurV2();
		//afficheur = new AfficheurModeTexte();
		afficheur = new AfficheurGraphique();
		*/
		MyFactory factory = new MyFactory();
		calculateur = factory.createCalculateur();
		afficheur = factory.createAfficheur();
		//1 saisir x
		double x;
		x=afficheur.saisir("x:");
		//2 calculer racine carrée
		double y = calculateur.racineCarree(x);
		//3 afficher le résultat
		afficheur.afficher("y="+y);
	}

	public static void main(String[] args) {
		MyCtrlApp app = new MyCtrlApp();
		app.sequence();
	}

}
