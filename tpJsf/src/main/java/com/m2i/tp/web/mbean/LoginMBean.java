package com.m2i.tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean //nom logique par defaut = "loginMBean"
   //nom classe java avec première lettre basculée en minuscules
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class LoginMBean {
	private String username="PowerUser"; //+get/set via lombok
	private String password="pwdPowerUser"; //+get/set via lombok
	private String message=""; //+get/set via lombok
	
	public String doLogin() {
		String suite=null; //rester sur meme page (par defaut)
		if(password.equals("pwd"+username)) {
			message="";
			suite="comptes"; //.jsp ou .xhtml
		}else {
			message="wrong username or password";
		}
		return suite;//changer de page (ou pas)
	}
}
