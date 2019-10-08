package com.m2i.tp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = { "comptes" })

@Entity
//@Table(name="Client")
@NamedQuery(name="Client.findAll",query="SELECT c FROM Client c")
public class Client {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client") //relation inverse
	@JsonIgnore //@JsonIgnore de la technologie jackson (utilisée en interne par Spring-MVC)
	            //demande à ignorer la partie ".comptes" lorsque l'obbjet java clinet est transformé en JSON
	private List<Compte> comptes;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr coté base
	                     //et remonte en mémoire la valeur auto incrémentée
	private Long numero;//Long en Majsucule pour null
	
	private String username;
	
	@Column(name="pwd") 
	private String password;
	
	private String roles;

}
