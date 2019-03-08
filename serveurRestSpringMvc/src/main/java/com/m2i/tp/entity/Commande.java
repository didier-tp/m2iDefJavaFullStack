package com.m2i.tp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity 
@Getter @Setter @NoArgsConstructor
@NamedQuery(name="Commande.findCommandeByClientId",
query="SELECT c FROM Commande c WHERE c.client.id = ?1")
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numCommande;
	//dateCommande
	
	@ManyToOne(/*fetch=FetchType.LAZY*/)
	@JoinColumn(name="ref_client") 
	//nom de la colomne clef etrangère (foreign key) dans la table Commande
	
	//@JsonIgnore
	private Client client;
	
	@ManyToMany
	@JoinTable(name="Commande_Produit",
	joinColumns= {@JoinColumn(name="ref_commande")},
	inverseJoinColumns= {@JoinColumn(name="ref_produit")})
	//@JsonIgnore
	private List<Produit> produits;

	@Override
	public String toString() {
		return "Commande [numCommande=" + numCommande + "]";
	}
	
	

}
