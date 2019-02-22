package com.m2i.tp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Produit.produitsByCategorieId",
			    query="SELECT p FROM Produit p INNER JOIN p.categories c WHERE c.id = :catId "),
	@NamedQuery(name="Produit.produitsByCategorieName",
	            query="SELECT p FROM Produit p INNER JOIN p.categories c WHERE c.label = ?1 ")
})
public class Produit {
	@Id
	// NB: strategy IDENTITY ok pour Mysql récent , H2, ...
	// ça demande auto_increment mysql
	// la valeur auto incrémentée par mysql remontera
	// automatiquement en mémoire dans l'attribut numero
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	//méthode falculatative mais pratique (fiable et facile à appeler):
		public void addCategorie(Categorie c) {
			if(this.categories==null) {
				this.categories=new ArrayList<Categorie>();
			}
			this.categories.add(c);
		}

	@Column(name = "label", length = 64) // VARCHAR(64)
	private String label;

	private double prix;

	/*
	//Ancienne version 
	@ManyToOne // Many "coté courant" to One "ce qu'il y a en dessous"
	@JoinColumn(name = "idCategorie") // nom de la colonne "clef etrangère"
	private Categorie categorie; // avec get/set
	*/
	
	//nouvelle version :
	@ManyToMany 
	@JoinTable(name = "Produit_Categorie",
	  joinColumns = {@JoinColumn(name = "produitId")},
	  inverseJoinColumns = {@JoinColumn(name = "catId")})
	private List<Categorie> categories; // avec get/set
	
	
	

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

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	

}
