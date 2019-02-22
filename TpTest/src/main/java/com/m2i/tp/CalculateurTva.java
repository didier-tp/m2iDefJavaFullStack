package com.m2i.tp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Code du composant (à tester).
public class CalculateurTva {

	private Logger logger = LoggerFactory.getLogger(CalculateurTva.class);

	public double tva(double ht, double tauxTvaPct) {
		if (tauxTvaPct < 0) {
			logger.error("tauxTvaPct negatif invalide");
			// logger.error("message erreur", exceptionXy);
			throw new RuntimeException("tauxTvaPct negatif invalide");
		}
		return ht * tauxTvaPct / 100;
		// return 0.0;
	}

	public double ttc(double ht, double tauxTvaPct) {
		return ht + tva(ht, tauxTvaPct);
		// return 0.0;
	}

}
