package com.m2i.tp.entity;

public class Produit {
	private Long numero;
	private String label;
	private double prix;

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

}
