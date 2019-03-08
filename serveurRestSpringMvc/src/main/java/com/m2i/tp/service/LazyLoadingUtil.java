package com.m2i.tp.service;

import java.util.Collection;

public class LazyLoadingUtil {
	
	public static void loadImmediatlyLazyCollection(Collection<?> c) {
		//c.size(); //NB: appeler .size() sur une collection force un parcours interne
		          //pour connaitre la taille
		//ou bien 
		for(Object obj : c) { } //boucle for (à vide) sur une collection
		//pour demander à Jpa/Hibernate
		//une remontée immédiate des éléments d'une sous collection
		//avant qu'il ne soit trop tard (entityManager.close() ou ...)
		// ceci permet d'éviter un LazyInitializationException
	}

}
