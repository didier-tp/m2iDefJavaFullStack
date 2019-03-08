package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.m2i.tp.dto.LoginRequest;
import com.m2i.tp.dto.LoginResponse;

public class LoginWsIT {
	private static Logger logger = LoggerFactory.getLogger(LoginWsIT.class);
	
	private static RestTemplate restTemplate; //objet technique de Spring pour test WS REST
	private static String baseURL;
	private static String serverName;
	
	//pas de @Autowired ni de @RunWith
	//car ce test EXTERNE est censé tester le WebService sans connaître sa structure interne
	// (test BOITE_NOIRE)
	@BeforeClass
	public static void init(){
	   restTemplate = new RestTemplate();
	   serverName="localhost";
	   //serverName="172.28.10.81"; //poste didier/formateur
	   baseURL="http://"+serverName+":8080/serveurRestSpringMvc/rest/login";
	}
	
	
	
	@Test
	public void testLogin(){
	//post/envoi:
	LoginRequest loginRequest = new LoginRequest("PowerUser","pwdPowerUser");

	LoginResponse loginResponse =restTemplate.postForObject(baseURL, loginRequest, LoginResponse.class);
	logger.info("loginResponse: " + loginResponse.toString());
	Assert.assertNotNull(loginResponse);
	}
	
}
