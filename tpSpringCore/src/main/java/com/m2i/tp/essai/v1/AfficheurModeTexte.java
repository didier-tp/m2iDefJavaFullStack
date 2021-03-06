package com.m2i.tp.essai.v1;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.m2i.tp.essai.Afficheur;

@Component
public class AfficheurModeTexte implements Afficheur {

	@Override
	public double saisir(String message) {
		Scanner s = new Scanner(System.in);
		System.out.print(message);
		return s.nextDouble();
	}

	@Override
	public void afficher(String message) {
		System.out.println(message);
	}

}
