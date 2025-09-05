package com.ccp.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SpringConfig {
	
@Bean
public SecurityFilterChain security(HttpSecurity http)throws Exception{
		
		return http
				.authorizeHttpRequests(registry ->{
					registry.requestMatchers("/","/login").permitAll();
					registry.anyRequest().authenticated();
				})
				.oauth2Login(oauth2login ->{
					oauth2login
					.loginPage("/login")
					.successHandler(new AuthenticationSuccessHandler() {
						
						@Override
						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
								Authentication authentication) throws IOException, ServletException {
							// TODO Auto-generated method stub
						response.sendRedirect("/profile");
						
					}
				});
				})
				.build();
	}

}
