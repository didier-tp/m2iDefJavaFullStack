package com.m2i.tp.essai;

import lombok.NoArgsConstructor;
import lombok.Setter;

//Version Spring (avec injection de dépendance)
//qui va remplacer l'ancien "MyCtrlApp" (sans spring)
@NoArgsConstructor
@Setter //pour générer les méthodes en set (pour injection via config xml)
public class MyCtrlSpring {
	
	private Calculateur calculateur/*=null*/; //+set
	
	private Afficheur afficheur/*=null*/; //+set
	
	public void sequence() {
		double x= afficheur.saisir("x:");
		double y = calculateur.racineCarree(x);
		afficheur.afficher("y="+y);
	}

}
