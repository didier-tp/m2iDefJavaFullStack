package com.m2i.tp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter @NoArgsConstructor @ToString
public class Adresse {
	
	@Column(name="num_et_rue")
	private String numEtRue;
	@Column(name="code_postal")
	private String codePostal;
	private String ville;
		
	public Adresse(String numEtRue, String codePostal, String ville) {
		this.numEtRue = numEtRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	

}
