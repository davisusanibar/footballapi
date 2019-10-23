package com.susanibar.david.footballapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// FIXME: Add security configuration to protect REST services: OAuth 2.0 + OIDC
public class FootballapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballapiApplication.class, args);
	}

}
