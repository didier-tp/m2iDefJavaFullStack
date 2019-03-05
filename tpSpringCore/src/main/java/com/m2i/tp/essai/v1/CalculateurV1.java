package com.m2i.tp.essai.v1;

import com.m2i.tp.essai.Calculateur;

public class CalculateurV1 implements Calculateur {

	@Override
	public double racineCarree(double x) {
		System.out.println("racineCarree - V1");
		return Math.sqrt(x);
	}

}
