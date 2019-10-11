package com.m2i.tp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class GenericResponse {
	String message;

	public GenericResponse(String message) {
		super();
		this.message = message;
	}
	
	
}
