package com.m2i.tp.essai;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemarrageSpring {

	public static void main(String[] args) {
		//initialisation de spring en fonction d'un fichier de config
		//à ce moment spring créer automatiquement tous les composants
		//de l'appli et les relie entre eux
		ClassPathXmlApplicationContext springContext =
				new ClassPathXmlApplicationContext("/mySpringConf.xml");
		
		//on accède à un composant préparé par spring
		MyCtrlSpring ctrlSpring = 
				//(MyCtrlSpring) springContext.getBean("idCtrlSpring");
				springContext.getBean(MyCtrlSpring.class);
		
		//on utilise le composant préparé par spring:
		ctrlSpring.sequence();
		
		springContext.close();
	}

}
