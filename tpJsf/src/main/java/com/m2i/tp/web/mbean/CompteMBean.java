package com.m2i.tp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	
	//com.m2i.tp.service.ServiceCompte version simulée sans Spring , sans Mysql
	//private com.m2i.tp.service.ServiceCompteSimu serviceCompte;
	
	//@ManagedProperty est à peu près l'équivalent jsf de @Autowired de spring
	//ça configure une injection de dépendance vers le composant (içi "spring")
	//dont l'id est serviceCompteImpl (nom classe Spring avec @Service
	// avec premiere lettre en minuscule).
	@ManagedProperty("#{serviceCompteImpl}")
	private ServiceCompte serviceCompte ; //+get/set via lombok ou via eclipse
	
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
		 //serviceCompte = com.m2i.tp.service.ServiceCompteSimu.getInstance(); //singleton
		 
		//NB: en mode développement , le sous projet tpSpringCore
		// utilise jpa/hibernate en mode hbm2ddl.auto=create
		// et la base de données mysql est réinitailisée à vide à chaque
		// redémarrage de l'application
		
		comptes = serviceCompte.comptesDuClient(); 
		//jeu de données pour tp (à ajouter qu'une fois):
		if(comptes.isEmpty()) {
			Compte cA = new Compte(null,"compte A",50.0);
			serviceCompte.sauvegarder(cA);
			Compte cB = new Compte(null,"compte B",30.0);
			serviceCompte.sauvegarder(cB);
		}
		
		comptes = serviceCompte.comptesDuClient();
	}
	
	public String effectuerVirement() {
		String suite=null;
		if(numCptDeb==numCptCred) {
			FacesContext.getCurrentInstance().addMessage(null, 
			new FacesMessage("virement impossible","numCptDeb==numCptCred"));
			//à afficher via <h:messages globalOnly="true" showDetail="true"/>
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
