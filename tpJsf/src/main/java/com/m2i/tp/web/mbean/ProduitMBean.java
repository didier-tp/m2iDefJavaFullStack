package com.m2i.tp.web.mbean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class ProduitMBean {
	
	private Date date;
	
	public String doDo() {
		String suite=null;
		System.out.println("date="+date);
		return suite;
	}

}
