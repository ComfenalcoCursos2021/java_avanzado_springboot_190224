package com.grupo.spring.logueo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.spring.logueo.dal.LoginDal;
import com.grupo.spring.logueo.dtos.LoginDto;
import com.grupo.spring.logueo.dtos.ResultadoDto;
import com.grupo.spring.logueo.entidades.LoginEntidad;

@Service
public class LoginServicio {
	@Autowired
	private LoginDal dal;	
	private ObjectMapper mapper = new ObjectMapper();	
	
	@Autowired
	PasswordEncoder encriptador;
	
	public ResultadoDto<List<LoginDto>> obtenerTodos() {		
		List<LoginDto> lista = mapper.convertValue(dal.obtenerTodos(), List.class);
		return ResultadoDto.ok(lista);
	}
	public ResultadoDto<LoginDto> obtenerPorId(int id) {
		Optional<LoginEntidad> entidad = dal.obtenerPorId(id);
		if(entidad.isPresent()) {
			return ResultadoDto.ok(mapper.convertValue(entidad.get(), LoginDto.class));
		}
		return ResultadoDto.todoMal("No se encontro el usuario");
	}
	
	public ResultadoDto<LoginDto> guardar(LoginDto dto) {
		
		LoginEntidad entidad = mapper.convertValue(dto, LoginEntidad.class);
		
		entidad.setPass(dto.getPass());	
		String passEncriptada = this.encriptador.encode(entidad.getPass());
		entidad.setPass(passEncriptada);
		LoginEntidad guardado = dal.guardar(entidad);
		return ResultadoDto.ok(mapper.convertValue(guardado, LoginDto.class));
	}
	
	public ResultadoDto<LoginDto> actualizar(LoginDto dto) {		
		LoginEntidad entidad = mapper.convertValue(dto, LoginEntidad.class);
		Optional<LoginEntidad> entidadActualizada = dal.actualizar(entidad);
		if(entidadActualizada.isPresent()) {
			return ResultadoDto.ok(mapper.convertValue(entidadActualizada.get(), LoginDto.class));
		}
		return ResultadoDto.todoMal("No se actualizo el usuario");		
	}
	
	public ResultadoDto<Boolean> borrar(int id) {
		
		boolean borro = dal.borrar(id);
		return borro ? ResultadoDto.ok(true) : ResultadoDto.todoMal("No se encontro el usuario");
	}
}
