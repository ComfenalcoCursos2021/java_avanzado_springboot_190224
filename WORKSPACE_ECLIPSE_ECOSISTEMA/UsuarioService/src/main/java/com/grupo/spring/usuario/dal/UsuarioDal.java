package com.grupo.spring.usuario.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.spring.usuario.entidades.UsuarioEntidad;
import com.grupo.spring.usuario.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioDal {

	@Autowired
	IUsuarioRepositorio repositorio;
	
	public List<UsuarioEntidad> obtenerTodos() {		
		return repositorio.findAll();
	}
	
	public Optional<UsuarioEntidad> obtenerPorId(int id) {
		return repositorio.findById(id);
	}
	
	public UsuarioEntidad guardar(UsuarioEntidad entidad) {
		return repositorio.save(entidad);
	}
	
	public Optional<UsuarioEntidad> actualizar(UsuarioEntidad entidadActualizar) {
		
		Optional<UsuarioEntidad> entidadEncontrada = repositorio.findById(entidadActualizar.getId());
		if(entidadEncontrada.isPresent()) {
			UsuarioEntidad entidad = entidadEncontrada.get();
			entidad.setNombre(entidadActualizar.getNombre());
			entidad.setCorreo(entidadActualizar.getCorreo());
			entidad.setPassword(entidadActualizar.getPassword());
			
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
