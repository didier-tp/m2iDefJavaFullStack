package com.m2i.tp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DTO = Data Transfert Object
//    = objet (ici java <--> json ) pour véhiculer/transférer
//      des données (ici "ordre de mise en promotion")
//      à travers le réseau (ex: entre client js et WS REST java)

@Getter @Setter @NoArgsConstructor
public class Promo {
	private Double tauxReductionPct;
	//... typeProduit //pour eventuel filtrage sur produits à mettre 
	                  //en promo
}
