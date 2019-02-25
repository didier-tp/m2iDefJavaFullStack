package com.m2i.tp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) in super-class
@DiscriminatorValue("Vetement")
public class Vetement extends Produit{
	private Integer taille;
	private String couleur;
	
	public Vetement() {
		super();
	}
	public Vetement(Long numero, String label, double prix) {
		super(numero, label, prix);
	}
	public Vetement(Long numero, String label, double prix,Integer taille, String couleur) {
		super(numero, label, prix);
		this.taille = taille;
		this.couleur = couleur;
	}
	
	
	
	@Override
	public String toString() {
		return "Vetement [taille=" + taille + ", couleur=" + couleur + ", heritant de " + super.toString() + "]";
	}
	public Integer getTaille() {
		return taille;
	}
	public void setTaille(Integer taille) {
		this.taille = taille;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
