package com.grupo.spring.logueo.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.grupo.spring.logueo.filtros.JwtLogueoFiltro;
import com.grupo.spring.logueo.filtros.JwtValidacionFiltro;

@Configuration
public class SeguridadConfiguracion {

	@Autowired
	private AuthenticationConfiguration authConf;
	
	@Bean
	AuthenticationManager authManager() throws Exception {
		return this.authConf.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder encriptadorDeContrasenias() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filtroPersonalizado(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				(autorizaciones) ->
					autorizaciones
					.requestMatchers(HttpMethod.GET ,"/api/tablalogin").permitAll()
					.requestMatchers(HttpMethod.POST ,"/api/tablalogin").permitAll()
					.anyRequest()
					.authenticated()
					
					
				)
					.addFilter(new JwtLogueoFiltro(authManager()))
					.addFilter(new JwtValidacionFiltro(authManager()))
					.csrf(
						configuracion -> 
						configuracion.disable())
					.sessionManagement(m -> m.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.build();
				
		
	}
	
	
}
