package com.m2i.tp.web.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.m2i.tp.entity.Produit;
import com.m2i.tp.service.ServiceProduit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class ProduitMBean {
	
	private ServiceProduit serviceProduit = ServiceProduit.getInstance();
	private List<Produit> produits = new ArrayList<Produit>();
	private Long numCategorie; //numéro categorie slectionnée
	
	//...
	
	private Date date;
	
	public String doDo() {
		String suite=null;
		System.out.println("date="+date);
		return suite;
	}

}
