package com.ccp.oauth;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {
	
	@GetMapping("/")
	public String home() {
		return "welcome";
		
	}
	
	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

}
