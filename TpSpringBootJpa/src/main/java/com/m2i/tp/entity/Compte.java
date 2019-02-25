package com.m2i.tp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the compte database table.
 * 
 */
@Entity
@Getter @Setter @NoArgsConstructor
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	private String label;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;

	private Double solde;

	
}