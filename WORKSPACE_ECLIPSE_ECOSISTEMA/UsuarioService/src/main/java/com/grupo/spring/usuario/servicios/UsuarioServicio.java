package com.grupo.spring.usuario.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.spring.usuario.dal.UsuarioDal;
import com.grupo.spring.usuario.dtos.UsuarioDto;
import com.grupo.spring.usuario.dtos.ResultadoDto;
import com.grupo.spring.usuario.entidades.UsuarioEntidad;

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioDal dal;	
	private ObjectMapper mapper = new ObjectMapper();	
	
	public ResultadoDto<List<UsuarioDto>> obtenerTodos() {		
		List<UsuarioDto> lista = mapper.convertValue(dal.obtenerTodos(), List.class);
		return ResultadoDto.ok(lista);
	}
	public ResultadoDto<UsuarioDto> obtenerPorId(int id) {
		Optional<UsuarioEntidad> entidad = dal.obtenerPorId(id);
		if(entidad.isPresent()) {
			return ResultadoDto.ok(mapper.convertValue(entidad.get(), UsuarioDto.class));
		}
		return ResultadoDto.todoMal("No se encontro el usuario");
	}
	
	public ResultadoDto<UsuarioDto> guardar(UsuarioDto dto) {
		
		UsuarioEntidad entidad = mapper.convertValue(dto, UsuarioEntidad.class);
		UsuarioEntidad guardado = dal.guardar(entidad);
		return ResultadoDto.ok(mapper.convertValue(guardado, UsuarioDto.class));
	}
	
	public ResultadoDto<UsuarioDto> actualizar(UsuarioDto dto) {		
		UsuarioEntidad entidad = mapper.convertValue(dto, UsuarioEntidad.class);
		Optional<UsuarioEntidad> entidadActualizada = dal.actualizar(entidad);
		if(entidadActualizada.isPresent()) {
			return ResultadoDto.ok(mapper.convertValue(entidadActualizada.get(), UsuarioDto.class));
		}
		return ResultadoDto.todoMal("No se actualizo el usuario");		
	}
	
	public ResultadoDto<Boolean> borrar(int id) {
		
		boolean borro = dal.borrar(id);
		return borro ? ResultadoDto.ok(true) : ResultadoDto.todoMal("No se encontro el usuario");
	}
}
