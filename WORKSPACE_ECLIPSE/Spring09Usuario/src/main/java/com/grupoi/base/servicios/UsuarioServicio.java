package com.grupoi.base.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoi.base.dal.UsuarioDal;
import com.grupoi.base.dtos.UsuarioDto;
import com.grupoi.base.entidades.UsuarioEntidad;

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioDal usuarioDal;
	
	public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
		
		UsuarioEntidad usuarioEntidadParaGuardar = new UsuarioEntidad();
		
		usuarioEntidadParaGuardar.setNombre(usuarioDto.getNombre());
		usuarioEntidadParaGuardar.setApellido(usuarioDto.getApellido());
		usuarioEntidadParaGuardar.setTelefono(usuarioDto.getTelefono());
		usuarioEntidadParaGuardar.setDireccion(usuarioDto.getDireccion());		
		
		UsuarioEntidad usuarioEntidadGuardado = usuarioDal.guardarUsuarioEnBaseDatos(usuarioEntidadParaGuardar);
		
		UsuarioDto usuarioDtoGuardado = new UsuarioDto();
		
		usuarioDtoGuardado.setId(usuarioEntidadGuardado.getId());
		usuarioDtoGuardado.setNombre(usuarioEntidadGuardado.getNombre());
		usuarioDtoGuardado.setApellido(usuarioEntidadGuardado.getApellido());		
		usuarioDtoGuardado.setTelefono(usuarioEntidadGuardado.getTelefono());
		usuarioDtoGuardado.setDireccion(usuarioEntidadGuardado.getDireccion());
		
		return usuarioDtoGuardado;
	}
	
	public List<UsuarioDto> obtenerTodos() {
		List<UsuarioEntidad> listaUsuarioEntidad  = usuarioDal.consultarTodos();
		List<UsuarioDto> listaUsuarioDto = new ArrayList<UsuarioDto>();
		
		for(int i = 0; i< listaUsuarioEntidad.size() ; i++) {
			UsuarioEntidad elemento = listaUsuarioEntidad.get(i); 
			
			UsuarioDto temporal = new UsuarioDto();
			temporal.setId(elemento.getId());
			temporal.setApellido(elemento.getApellido());
			temporal.setNombre(elemento.getNombre());
			temporal.setDireccion(elemento.getDireccion());
			temporal.setTelefono(elemento.getTelefono());
			
			listaUsuarioDto.add(temporal);
		}
		return listaUsuarioDto;
		
	}
	public boolean borrar(int idParaBorrar) {
		boolean respuesta = usuarioDal.borrar(idParaBorrar);
		return respuesta;
	}
	
	public UsuarioDto actualizar(UsuarioDto usuarioParaActulizar) {
		
		UsuarioEntidad usuarioEntidadParaActulizar = new UsuarioEntidad();
		usuarioEntidadParaActulizar.setId(usuarioParaActulizar.getId());
		usuarioEntidadParaActulizar.setNombre(usuarioParaActulizar.getNombre());
		usuarioEntidadParaActulizar.setApellido(usuarioParaActulizar.getApellido());
		usuarioEntidadParaActulizar.setTelefono(usuarioParaActulizar.getTelefono());
		usuarioEntidadParaActulizar.setDireccion(usuarioParaActulizar.getDireccion());	
		
		boolean respuesta = usuarioDal.actualizar(usuarioEntidadParaActulizar);
		if(respuesta) {
			UsuarioEntidad usuarioConsultado = usuarioDal.obtenerPorId(usuarioEntidadParaActulizar.getId());
			UsuarioDto usuarioDtoActulizado = new UsuarioDto();
			usuarioDtoActulizado.setId(usuarioConsultado.getId());
			usuarioDtoActulizado.setNombre(usuarioConsultado.getNombre());
			usuarioDtoActulizado.setApellido(usuarioConsultado.getApellido());
			usuarioDtoActulizado.setDireccion(usuarioConsultado.getDireccion());
			usuarioDtoActulizado.setTelefono(usuarioConsultado.getTelefono());
			
			return usuarioDtoActulizado;
		} else {
			return new UsuarioDto();
		}
		
		
	}
	
	public UsuarioDto obtenerUnUsuario(int id) {
		UsuarioEntidad usuarioEntidad = usuarioDal.obtenerPorId(id);
		
		UsuarioDto usuarioDtoEncontrado = new UsuarioDto();
		usuarioDtoEncontrado.setId(usuarioEntidad.getId());
		usuarioDtoEncontrado.setNombre(usuarioEntidad.getNombre());
		usuarioDtoEncontrado.setApellido(usuarioEntidad.getApellido());
		usuarioDtoEncontrado.setDireccion(usuarioEntidad.getDireccion());
		usuarioDtoEncontrado.setTelefono(usuarioEntidad.getTelefono());
		return usuarioDtoEncontrado;
		
	}
	
	
}
