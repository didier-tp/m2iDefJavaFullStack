package com.m2i.tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = { "client" })
@Entity
@NamedQuery(name="Compte.findByClientNum",query="SELECT cpt FROM Compte cpt WHERE cpt.client.numero = ?1")
public class Compte {
	
	@ManyToOne()
	@JoinColumn(name = "id_client")
	private Client client;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	private String label;
	private Double solde;

}
