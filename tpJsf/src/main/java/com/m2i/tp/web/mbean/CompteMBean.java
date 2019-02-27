package com.m2i.tp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	
	//pour le virement:
	private Double montantVir;
	private Long numCptDeb;
	private Long numCptCred;
	
	@PostConstruct
	//@PostConstruct est une annotation standard de java/ee
	//qui sert à déclencher une méthode d'initialisation 
	// - après le new et le constructeur
	// - après les injections de dépendances
	public void init() {
		 serviceCompte = ServiceCompte.getInstance(); //singleton
		 comptes = serviceCompte.comptesDuClient();
	}
	
	public String effectuerVirement() {
		String suite=null;
		if(numCptDeb==numCptCred) {
			FacesContext.getCurrentInstance().addMessage(null, 
			new FacesMessage("virement impossible","numCptDeb==numCptCred"));
		}else {
		//déléguer le virement au serviceCompte:
		serviceCompte.virement(montantVir, numCptDeb, numCptCred);
		//réactualiser la liste des comptes
		comptes = serviceCompte.comptesDuClient();
		//naviguer vers comptes.xhtml pour afficher les nouvelles valeurs:
		suite =  "comptes"; //.xhtml
		}
		return suite;
	}
	

}
