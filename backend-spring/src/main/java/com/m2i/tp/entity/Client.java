package com.m2i.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString

@Entity
//@Table(name="Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_incr coté base
	                     //et remonte en mémoire la valeur auto incrémentée
	private Long numero;//Long en Majsucule pour null
	
	private String username;
	
	@Column(name="pwd")
	private String password;
	
	private String roles;

}
