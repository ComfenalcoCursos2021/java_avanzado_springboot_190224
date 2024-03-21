package com.grupo.spring.configuraciones.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfiguracion {

	@Autowired
	private BuscadorUsuariosImpl buscador;
	
	@Bean
	public SecurityFilterChain filtroDeSeguridad(HttpSecurity http,AuthenticationManager autenticador) throws Exception {
		
		return http.csrf().disable()
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement().sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)
				.and()
				.build();
	}
	@Bean
	public PasswordEncoder cifrar() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager autenticador(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(buscador)
				.passwordEncoder(cifrar())
				.and()
				.build();
	}
	
}
