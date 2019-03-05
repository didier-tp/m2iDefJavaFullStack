package com.m2i.tp.essai;

import java.util.Properties;

public class MyFactory {
	
	private String propertyFile="my-props.properties";
	private String afficheurClassName=null;
	private String calculateurClassName=null;
	
	public MyFactory(){
		Properties props = new Properties(); //java.util	
		try {	props.load(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream(propertyFile));
		} catch (Exception e) {			e.printStackTrace();		}
		this.afficheurClassName = props.getProperty("afficheurClassName");
		this.calculateurClassName = props.getProperty("calculateurClassName");
	}
	
	public Calculateur createCalculateur() {
		Calculateur c=null;
		try {	//        c = new com.m2i.tp.essai.CalculateurV1();
			//ou bien c = new com.m2i.tp.essai.CalculateurV2();
			c=(Calculateur) Class.forName(calculateurClassName).newInstance();
		} catch (Exception e) {			e.printStackTrace();		}
		return c;
	}
	
	public Afficheur createAfficheur() {
		Afficheur a=null;
		try {
			//        c = new com.m2i.tp.essai.AfficheurModeTexte();
			//ou bien c = new com.m2i.tp.essai.AfficheurGraphique();
			a=(Afficheur) Class.forName(afficheurClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
