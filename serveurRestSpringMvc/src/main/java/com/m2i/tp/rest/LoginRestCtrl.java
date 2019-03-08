package com.m2i.tp.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.dto.LoginRequest;
import com.m2i.tp.dto.LoginResponse;

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/login" , headers="Accept=application/json")
public class LoginRestCtrl {
	
		
	//URL = http://localhost:8080/serveurRestSpringMvc/rest/login en POST
	@RequestMapping(value="" , method=RequestMethod.POST)
	public LoginResponse loginAsAdmin(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		if(loginRequest.getPassword() != null 
		   && loginRequest.getPassword().equals("pwd"+loginRequest.getUsername())
		   ) {
			loginResponse.setOk(true); loginResponse.setMessage("login sucessful");
			loginResponse.setToken(BasicSecurity.VALID_TOKEN);
		}else {
			loginResponse.setOk(false); loginResponse.setMessage("login error, try again");
			loginResponse.setToken("no arm , no chocolate");
		}
		return loginResponse;
	}
	

}
