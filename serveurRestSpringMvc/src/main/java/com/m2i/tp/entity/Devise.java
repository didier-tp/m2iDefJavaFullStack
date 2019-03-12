package com.m2i.tp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Devise {
	
	@Id
	private String code; //EUR ou USD ou ...
	private String nom;
	private Double dChange; //nb euros pour 1 dollar
	
	public Devise(String code, String nom, Double dChange) {
		super();
		this.code = code;
		this.nom = nom;
		this.dChange = dChange;
	}
	
	

}
