package com.m2i.tp.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.m2i.tp.service.Convertisseur")
public class ConvertisseurImpl implements Convertisseur{
	
	private static final double COEFF_EURO_FRANC=6.55957;

	@Override
	public double euroToFranc(double montantEuro) {
		return montantEuro * COEFF_EURO_FRANC;
	}

	@Override
	public double francToEuro(double montantFranc) {
		return  montantFranc / COEFF_EURO_FRANC;
	}

	@Override
	public String getAuteur() {
		return "didier";
	}

}
