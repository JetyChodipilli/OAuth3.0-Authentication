package com.ccp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileCOntroller {
	
	    @GetMapping("/profile")
	    public String getProfile(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
	        // Extract user details from OAuth2User (Google in this case)
	        String name = oAuth2User.getAttribute("name");
	        String email = oAuth2User.getAttribute("email");
	        String photo = oAuth2User.getAttribute("picture");

	        // Add attributes to the model
	        model.addAttribute("name", name);
	        model.addAttribute("email", email);
	        model.addAttribute("photo", photo);

	        // Return the Thymeleaf template name
	        return "profile";
	    }
	    @GetMapping("/login")
	    public String login() {
	        return "login_page"; // Maps to login.html
	    }
	
}
