package com.m2i.tp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Conversion {
	
	private Double montantSource;
	private String codeMonnaieSource;
	private String codeMonnaieCible;
	
	private Double montantCible;//resultat de la conversion

	public Conversion(Double montantSource, String codeMonnaieSource, String codeMonnaieCible, Double montantCible) {
		super();
		this.montantSource = montantSource;
		this.codeMonnaieSource = codeMonnaieSource;
		this.codeMonnaieCible = codeMonnaieCible;
		this.montantCible = montantCible;
	}

	
}
