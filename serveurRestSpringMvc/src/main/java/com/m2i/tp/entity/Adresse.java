package com.m2i.tp.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor  @ToString
@Embeddable //ne comporte pas de @Id , à la place de @Entity
public class Adresse {
	private String numEtRue;
	private String codePostal;
	private String ville;
	
	public Adresse(String numEtRue, String codePostal, String ville) {
		super();
		this.numEtRue = numEtRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
}
