package com.m2i.tp.essai;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

//Version Spring (avec injection de dépendance)
//qui va remplacer l'ancien "MyCtrlApp" (sans spring)

@Setter //pour générer les méthodes en set (pour injection via config xml)
@Component
//@Scope("singleton") par defaut
public class MyCtrlSpring {
	
	private Logger logger = LoggerFactory.getLogger(MyCtrlSpring.class);
	
	@Autowired //pour demander à spring d'initialiser la 
	// référence calculateur pour que ça pointe vers un composant spring
	// existant qui est compatible avec l'interface Calculateur
	// NB: il faut bien régler les packages scrutés via compoent-scan
	// pour qu'un seul composant soit trouvé (si 0 ou 2 : erreur)
	private Calculateur calculateur/*=null*/; //+set
	
	@Autowired
	private Afficheur afficheur/*=null*/; //+set
	
	public MyCtrlSpring() {
		logger.trace("dans constructeur , calculateur=" + calculateur);
	}
	
	@PostConstruct
	public void initAfterInjections() {
		logger.trace("dans methode prefixee par @PostConstruct , calculateur="
	         + calculateur);
	}
	
	public void sequence() {
		double x= afficheur.saisir("x:");
		double y = calculateur.racineCarree(x);
		afficheur.afficher("y="+y);
	}

}
