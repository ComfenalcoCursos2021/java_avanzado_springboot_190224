package com.grupo.spring.logueo.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.spring.logueo.entidades.LoginEntidad;
import com.grupo.spring.logueo.repositorios.ILoginRepositorio;
@Service
public class LoginDal {
	@Autowired
	ILoginRepositorio repositorio;
	
	public List<LoginEntidad> obtenerTodos() {		
		return repositorio.findAll();
	}
	
	public Optional<LoginEntidad> obtenerPorId(int id) {
		return repositorio.findById(id);
	}
	
	public LoginEntidad guardar(LoginEntidad entidad) {
		return repositorio.save(entidad);
	}
	
	public Optional<LoginEntidad> actualizar(LoginEntidad entidadActualizar) {
		
		Optional<LoginEntidad> entidadEncontrada = repositorio.findById(entidadActualizar.getId());
		if(entidadEncontrada.isPresent()) {
			LoginEntidad entidad = entidadEncontrada.get();
			entidad.setNick(entidadActualizar.getNick());			
			entidad.setPass(entidadActualizar.getPass());			
			return Optional.of(repositorio.save(entidad));
			
		}
		return Optional.empty();
	}
	public boolean borrar(int id) {		
		if(repositorio.existsById(id)) {
			repositorio.deleteById(id);
			return true;
		}
		return false;
	}
}
