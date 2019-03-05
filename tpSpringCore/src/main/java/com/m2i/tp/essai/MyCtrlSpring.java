package com.m2i.tp.essai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.Setter;

//Version Spring (avec injection de dépendance)
//qui va remplacer l'ancien "MyCtrlApp" (sans spring)
@NoArgsConstructor
@Setter //pour générer les méthodes en set (pour injection via config xml)
@Component
public class MyCtrlSpring {
	
	@Autowired //pour demander à spring d'initialiser la 
	// référence calculateur pour que ça pointe vers un composant spring
	// existant qui est compatible avec l'interface Calculateur
	// NB: il faut bien régler les packages scrutés via compoent-scan
	// pour qu'un seul composant soit trouvé (si 0 ou 2 : erreur)
	private Calculateur calculateur/*=null*/; //+set
	
	@Autowired
	private Afficheur afficheur/*=null*/; //+set
	
	public void sequence() {
		double x= afficheur.saisir("x:");
		double y = calculateur.racineCarree(x);
		afficheur.afficher("y="+y);
	}

}
