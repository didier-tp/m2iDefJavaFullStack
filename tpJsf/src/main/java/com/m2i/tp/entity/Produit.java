package com.m2i.tp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/* avec dans pom.xml
          <dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>	 
			<version>1.16.22</version>
		</dependency>
 */
@Getter @Setter @NoArgsConstructor @ToString
//@Entity
public class Produit {
	//@Id
	private Long numero;
	private String label;
	private Double prix;
	
	public Produit(Long numero, String label, Double prix) {
		super();
		this.numero = numero;
		this.label = label;
		this.prix = prix;
	}

	
}
