package com.m2i.tp.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService //WebService SOAP
public interface Convertisseur {
	
	public double euroToFranc(@WebParam(name="montantEuro") double montantEuro);
	public double francToEuro(@WebParam(name="montantFranc") double montantFranc);
    public String getAuteur();
}
