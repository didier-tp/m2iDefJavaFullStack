package com.m2i.tp.essai;

import java.util.Scanner;

public class MyCtrlApp {
	
	public void sequence() {
		//1 saisir x
		double x;
		Scanner s = new Scanner(System.in);
		System.out.print("x=");
		x=s.nextDouble();
		//2 calculer racine carrée
		double y = Math.sqrt(x);
		//3 afficher le résultat
		System.out.println("y="+y);
	}

	public static void main(String[] args) {
		MyCtrlApp app = new MyCtrlApp();
		app.sequence();
	}

}
