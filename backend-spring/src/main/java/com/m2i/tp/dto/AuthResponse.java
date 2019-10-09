package com.m2i.tp.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO = Data Transfert Object (converti ici en JSON) pour communication Web-Service
//ce n'est pas une entité persitente (pas stocké en base).

@Getter @Setter @NoArgsConstructor @ToString
public class AuthResponse /*implements Serializable*/ {

	private String token;
	private String message;
	private Boolean ok;

}
