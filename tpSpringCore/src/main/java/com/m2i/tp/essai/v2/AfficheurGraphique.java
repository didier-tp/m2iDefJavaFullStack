package com.m2i.tp.essai.v2;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

import com.m2i.tp.essai.Afficheur;

@Component
public class AfficheurGraphique implements Afficheur {

	@Override
	public double saisir(String message) {
		String sValSaisie = JOptionPane.showInputDialog(null, message);
		return Double.parseDouble(sValSaisie);
	}

	@Override
	public void afficher(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
