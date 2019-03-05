package com.m2i.tp.essai;

public class CalculateurV1 implements Calculateur {

	@Override
	public double racineCarree(double x) {
		System.out.println("racineCarree - V1");
		return Math.sqrt(x);
	}

}
