package com.grupo.spring.configuraciones.seguridad;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BuscadorUsuariosImpl implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(!username.equals("admin")) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		User usuario = (User) User.builder()
				.username("admin")
				.password(cifrar().encode("root"))
				.roles()
				.build();
		return usuario;
	}
	public PasswordEncoder cifrar() {		
		return new BCryptPasswordEncoder();
	}

}
