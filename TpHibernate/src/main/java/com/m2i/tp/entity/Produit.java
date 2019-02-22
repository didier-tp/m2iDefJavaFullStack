package com.m2i.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	@Id
	// NB: strategy IDENTITY ok pour Mysql récent , H2, ...
	// ça demande auto_increment mysql
	// la valeur auto incrémentée par mysql remontera
	// automatiquement en mémoire dans l'attribut numero
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	@Column(name = "label", length = 64) // VARCHAR(64)
	private String label;

	private double prix;

	@ManyToOne // Many "coté courant" to One "ce qu'il y a en dessous"
	@JoinColumn(name = "idCategorie") // nom de la colonne "clef etrangère"
	private Categorie categorie; // avec get/set

	// +get/set , constructeurs , toString() , ...
	public Produit() {
		super();
	}

	public Produit(Long numero, String label, double prix) {
		super();
		this.numero = numero;
		this.label = label;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [numero=" + numero + ", label=" + label + ", prix=" + prix + "]";
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
