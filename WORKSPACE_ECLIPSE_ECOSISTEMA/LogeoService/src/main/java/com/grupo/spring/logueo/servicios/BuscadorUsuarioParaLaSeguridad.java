package com.grupo.spring.logueo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grupo.spring.logueo.entidades.LoginEntidad;
import com.grupo.spring.logueo.repositorios.ILoginRepositorio;

@Service
public class BuscadorUsuarioParaLaSeguridad implements UserDetailsService {

	@Autowired
	private ILoginRepositorio repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<LoginEntidad> entidad = repositorio.findByNick(username);
		
		if(!entidad.isPresent()) {
			throw new UsernameNotFoundException(String.format("El usuario %s no existe %s", username, username));
		}
		
		LoginEntidad login = entidad.get();
		List<GrantedAuthority> authoritiesRoles = new ArrayList<>();
		authoritiesRoles.add(new SimpleGrantedAuthority("USUARIO_ADMIN"));
		org.springframework.security.core.userdetails.User elUsuario = 
				new org.springframework.security.core.userdetails.User(
						login.getNick(), 
						login.getPass(),
						true,
						true,
						true,
						true,
						authoritiesRoles
						);
		return elUsuario;
	}

}
