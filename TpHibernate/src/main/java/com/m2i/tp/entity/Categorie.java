package com.m2i.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 64)
	private String label;

	public Categorie() {
		super();
	}

	public Categorie(Long id, String label) {
		super();
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

}
