package com.m2i.tp.rest;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.ServletComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.tp.entity.Produit;


@WebServlet(urlPatterns= "/servlet/ViaServlet")
//NB: @WebServlet est interprété par springBoot si @ServletComponentScan 
//est présent au dessus de MySpringBootApplication (main)
public class ViaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViaServlet() {  super();  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produit  p1 = new Produit(1L,"produit 1" , 12.0);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		String p1AsJsonString = jacksonObjectMapper.writeValueAsString(p1);
		out.print(p1AsJsonString);
	}

	
	
}
