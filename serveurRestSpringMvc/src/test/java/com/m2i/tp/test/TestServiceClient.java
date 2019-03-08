package com.m2i.tp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.MySpringBootApplication;
import com.m2i.tp.service.ServiceClient;



//Test unitaire du service métier "ServiceProduit"

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceClient {
	
	@Autowired
	private ServiceClient serviceClient; //à tester
	
	@Test
	public void testSelonDebutNom() {
		
	}
	
	@Test
	public void testCrud() {
		
	}

}
