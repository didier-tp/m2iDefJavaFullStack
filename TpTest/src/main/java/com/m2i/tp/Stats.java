package com.m2i.tp;

import java.util.ArrayList;
import java.util.List;

public class Stats {
	private List<Double> serie = new ArrayList<>();
	private int n;

	public void add(double val) {
		serie.add(val);
		n = serie.size();
	}

	public double somme() {

		double sum = 0;
		for (double v : serie) {
			sum += v;
		}
		return sum;
	}

	public double moyenne() {
		return somme() / n;
	}
}
