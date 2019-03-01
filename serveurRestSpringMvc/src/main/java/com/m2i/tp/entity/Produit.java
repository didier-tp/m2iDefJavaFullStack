package com.m2i.tp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter @Setter @NoArgsConstructor
public class Produit {
	//@Id
	private Long numero;
	private String label;
	private Double prix;
	
	
	public Produit(Long numero, String label, Double prix) {
		super();
		this.numero = numero;
		this.label = label;
		this.prix = prix;
	}
	
	

}
