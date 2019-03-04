package com.m2i.tp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Client {
	private Long id;
	private String nom;
	private String prenom;
	
	/*
	@JsonIgnore //pour ne pas suivre le lien vers le sous objet adresse
	            //lors des conversions java <--> json
	*/
	private Adresse adresse;
	
	private String email;
	private String telephone;
	
	
	
	public Client(Long id, String nom, String prenom, String email, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + "]";
	}
	
	

}
