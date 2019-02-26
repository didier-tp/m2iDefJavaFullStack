package com.m2i.tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean //nom logique par defaut = "calculMBean"
   //nom classe java avec première lettre basculée en minuscules
@RequestScoped
public class CalculMBean {
	private Double a; //+get/set
	//...
	public String doAdd() {
		String suite=null; //rester sur meme page (par defaut)
		//res=a+b;
		return suite;//changer de page (ou pas)
	}
}
