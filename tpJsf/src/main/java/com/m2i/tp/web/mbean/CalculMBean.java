package com.m2i.tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean //nom logique par defaut = "calculMBean"
   //nom classe java avec première lettre basculée en minuscules
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class CalculMBean {
	private Double a; //+get/set via lombok
	private Double b; //+get/set via lombok
	private Double res; //+get/set via lombok
	
	public String doAdd() {
		String suite=null; //rester sur meme page (par defaut)
		res=a+b;
		return suite;//changer de page (ou pas)
	}
	
	public String doMult() {
		String suite=null; //rester sur meme page (par defaut)
		res=a*b;
		return suite;//changer de page (ou pas)
	}
}
