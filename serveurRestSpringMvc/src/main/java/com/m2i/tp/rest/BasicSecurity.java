package com.m2i.tp.rest;

public class BasicSecurity {
	public static final String VALID_TOKEN="BasicValidToken";
	//sur vrai projet : token unique généré dynamiquement pour chaque utilisateur/login
	
	public static boolean verifyToken(String token) {
		return VALID_TOKEN.equals(token);
	}
}
