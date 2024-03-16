package com.grupoi.base.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoi.base.entidades.UsuarioEntidad;
import com.grupoi.base.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioDal {

	@Autowired
	IUsuarioRepositorio conexionUsuarioBaseDatos;
	
	public UsuarioEntidad guardarUsuarioEnBaseDatos(UsuarioEntidad entidadUsuario) {
		
		UsuarioEntidad entidadUsuarioGuardada = conexionUsuarioBaseDatos.save(entidadUsuario);		
		return entidadUsuarioGuardada;
	}
	
	public List<UsuarioEntidad> consultarTodos() {
		List<UsuarioEntidad> listaEntidades = conexionUsuarioBaseDatos.findAll();
		return listaEntidades;
	}
	
	public boolean borrar(int idParaBorrar) {		
		if(conexionUsuarioBaseDatos.findById(idParaBorrar).isPresent()) {
			conexionUsuarioBaseDatos.deleteById(idParaBorrar);
			return true;
		}
		
		return false;
	}
	
	public Optional<UsuarioEntidad> actualizar(UsuarioEntidad losValoresActualizar) {
		
		Optional<UsuarioEntidad> optUsuarioActualizado = Optional.empty(); 
		Optional<UsuarioEntidad> respuestaBaseDatos = conexionUsuarioBaseDatos.findById(losValoresActualizar.getId());
		if(respuestaBaseDatos.isPresent()) {
			UsuarioEntidad registroUsuario = respuestaBaseDatos.get();
			registroUsuario.setNombre(losValoresActualizar.getNombre());
			registroUsuario.setApellido(losValoresActualizar.getApellido());
			registroUsuario.setDireccion(losValoresActualizar.getDireccion());
			registroUsuario.setTelefono(losValoresActualizar.getTelefono());
			UsuarioEntidad usuarioEntidadActualizado = conexionUsuarioBaseDatos.save(registroUsuario);
			optUsuarioActualizado = Optional.of(usuarioEntidadActualizado);
			return optUsuarioActualizado;
		}
		
		return optUsuarioActualizado;
	}
	public Optional<UsuarioEntidad> obtenerPorId(int id) {
		Optional<UsuarioEntidad> respuestaBaseDatos = conexionUsuarioBaseDatos.findById(id);
		return respuestaBaseDatos;		
	}
}
