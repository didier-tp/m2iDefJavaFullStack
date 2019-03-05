package com.m2i.tp.essai.v2;

import org.springframework.stereotype.Component;

import com.m2i.tp.essai.Calculateur;

@Component
public class CalculateurV2 implements Calculateur {

	@Override
	public double racineCarree(double x) {
		System.out.println("racineCarree - v2");
		return Math.pow(x,0.5);
	}

}
