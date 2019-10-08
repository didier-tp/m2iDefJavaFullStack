package com.m2i.tp.devonly;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.m2i.tp.entity.Client;
import com.m2i.tp.service.ClientService;

@Component
@Profile("dev")
public class InitDataSet {
	
	@Autowired
	private ClientService clientService;
	

	@PostConstruct //appelée après constrcteur et après injections (paramétrées via autowired)
	private void initJeuxDonneesEnModeDeveloppement() {
		Client c1 = new Client(); c1.setUsername("user1");
		c1.setPassword("pwd1"); c1.setRoles("user,admin");
		clientService.sauvegarderClient(c1);
		
		Client c2 = new Client(); c2.setUsername("user2");
		c2.setPassword("pwd2"); c2.setRoles("user,admin");
		clientService.sauvegarderClient(c2);
	}
	
}
