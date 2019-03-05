package com.m2i.tp.essai.v1;

import org.springframework.stereotype.Component;

import com.m2i.tp.essai.Calculateur;

@Component //id par defaut = "calculateurV1" nom classe avec minuscule au début
//Cette classe sera prise en charge par Spring si:
//    - @Component (ou bien cas particulier @Service , @RestController, ...)
//    - component-scan bien réglé sur package "com.m2i...v1"
public class CalculateurV1 implements Calculateur {

	@Override
	public double racineCarree(double x) {
		System.out.println("racineCarree - V1");
		return Math.sqrt(x);
	}

}
