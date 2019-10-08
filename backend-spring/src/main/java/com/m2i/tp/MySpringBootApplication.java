package com.m2i.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
public class MySpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		//SpringApplication.run(MySpringBootApplication.class, args);
		SpringApplication app = new SpringApplication(MySpringBootApplication.class);
		/*if "--dev" in args */
		   app.setAdditionalProfiles("dev");
		app.run(args);
		System.out.println("http://localhost:8080/backend-spring");
	}

}
