package com.m2i.tp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class News {

	private Long id;
	private String title;
	private String text;
	public News(Long id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}
	
	

}
