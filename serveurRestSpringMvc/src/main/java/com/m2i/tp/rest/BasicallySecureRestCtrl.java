package com.m2i.tp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.dto.Secret;

//NB: securité très très basique pour première approche 
//(sans intercepteur , sans spring-security , sans jwt )

@RestController //composant spring de type WS REST
@RequestMapping(value="/rest/secure/secret" , headers="Accept=application/json")
public class BasicallySecureRestCtrl {
	
	private Map<Long,Secret> mapSecrets = new HashMap<>();
	
	public BasicallySecureRestCtrl() {
		mapSecrets.put(1L, new Secret(1L,"top secret"));
		mapSecrets.put(2L, new Secret(2L,"don't repeat"));
		mapSecrets.put(3L, new Secret(3L,"confidentiel"));
	}
	
	   //URL = http://localhost:8080/serveurRestSpringMvc/rest/secure/secret/1
		@RequestMapping(value="/{id}" , method=RequestMethod.GET)
		public ResponseEntity<Secret> getSecretById(@PathVariable("id")  Long id ,
				                            @RequestHeader HttpHeaders httpHeaders ){
			String token = extractBearerTokenFromHttpHeaders(httpHeaders);
			if(BasicSecurity.verifyToken(token)){
				Secret s = mapSecrets.get(id);
				if(s!=null)
					return new ResponseEntity<Secret>(s,HttpStatus.OK);
				else 
					return new ResponseEntity<Secret>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<Secret>(HttpStatus.UNAUTHORIZED);
				//ou HttpStatus.FORBIDDEN;
			}
		}
	
		public static String extractBearerTokenFromHttpHeaders(HttpHeaders headers){
			List<String> listOfAuthorization= headers.get(HttpHeaders.AUTHORIZATION);
			if(listOfAuthorization==null || listOfAuthorization.size()==0){
			return null;
			}
			String mainAuthorisation = listOfAuthorization.get(0);
			System.out.println(mainAuthorisation);
			if(mainAuthorisation.length()<8) {
			return null;
			}
			if(mainAuthorisation.startsWith("Bearer")){
			return mainAuthorisation.substring(7);
			}
			return null;
		}
	
}
