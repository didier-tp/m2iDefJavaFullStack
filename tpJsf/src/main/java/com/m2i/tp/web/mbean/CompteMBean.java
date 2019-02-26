package com.m2i.tp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.m2i.tp.entity.Compte;
import com.m2i.tp.service.ServiceCompte;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class CompteMBean {
	
	private List<Compte> comptes; //à afficher via un tableau
	private ServiceCompte serviceCompte;
	
	@PostConstruct
	//@PostConstruct est une annotation standard de java/ee
	//qui sert à déclencher une méthode d'initialisation 
	// - après le new et le constructeur
	// - après les injections de dépendances
	public void init() {
		 serviceCompte = new ServiceCompte(); //ou singleton
		 comptes = serviceCompte.comptesDuClient();
	}

}
