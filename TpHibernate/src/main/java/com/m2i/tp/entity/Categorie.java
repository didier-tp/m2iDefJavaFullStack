package com.m2i.tp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 64)
	private String label;

	// Le "@OneToMany" symétrique du "@ManyToOne" est facultatif
	@OneToMany(mappedBy = "categorie",fetch=FetchType.LAZY) // valeur de mappedBy ="nom_java_relation_inverse"
	private List<Produit> produits;// avec get/set

	public Categorie() {
		super();
		produits= new ArrayList<Produit>();
	}

	public Categorie(Long id, String label) {
		super();
		produits= new ArrayList<Produit>();
		this.id = id;
		this.label = label;
	}

	

	

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", label=" + label + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
