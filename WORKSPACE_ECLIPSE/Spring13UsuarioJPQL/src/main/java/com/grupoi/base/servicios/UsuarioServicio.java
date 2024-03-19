package com.grupoi.base.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupoi.base.dal.UsuarioDal;
import com.grupoi.base.dtos.ResultadoDto;
import com.grupoi.base.dtos.UsuarioDto;
import com.grupoi.base.entidades.UsuarioEntidad;

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioDal usuarioDal;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public ResultadoDto<UsuarioDto> guardarUsuario(UsuarioDto usuarioDto) {
		
		try {
			UsuarioEntidad usuarioEntidadParaGuardar = new UsuarioEntidad();		
			usuarioEntidadParaGuardar = mapper.readValue(mapper.writeValueAsString(usuarioDto), UsuarioEntidad.class);		
			UsuarioEntidad usuarioEntidadGuardado = usuarioDal.guardarUsuarioEnBaseDatos(usuarioEntidadParaGuardar);		
			UsuarioDto usuarioDtoGuardado = mapper.readValue(mapper.writeValueAsString(usuarioEntidadGuardado), UsuarioDto.class);		
			return ResultadoDto.<UsuarioDto>ok(usuarioDtoGuardado);
		} catch(JsonProcessingException e) {
			return ResultadoDto.<UsuarioDto>todoMal("Las propiedades no pudieron ser asignadas");
		} catch(Exception e) {
			return ResultadoDto.<UsuarioDto>todoMal(e.toString());	
		}
		
	}
	
	public ResultadoDto<List<UsuarioDto>> obtenerTodos() {
		try {
			List<UsuarioEntidad> listaUsuarioEntidad  = usuarioDal.consultarTodos();
			List<UsuarioDto> listaUsuarioDto = new ArrayList<UsuarioDto>();
			
			listaUsuarioDto = 
					Arrays.asList(mapper.readValue(mapper.writeValueAsString(listaUsuarioEntidad),UsuarioDto[].class));

			return ResultadoDto.<List<UsuarioDto>>ok(listaUsuarioDto);
	    } catch(JsonProcessingException e) {
	        return ResultadoDto.<List<UsuarioDto>>todoMal("Las propiedades no pudieron ser asignadas");
	    } catch(Exception e) {
	        return ResultadoDto.<List<UsuarioDto>>todoMal(e.toString());  
	    }		
	}
	public ResultadoDto<Boolean> borrar(int idParaBorrar) {
		boolean respuesta = usuarioDal.borrar(idParaBorrar);
		return respuesta ? ResultadoDto.<Boolean>ok(true) : ResultadoDto.<Boolean>todoMal("No se pudo borrar el usuario");
	}
	
	public ResultadoDto<UsuarioDto> actualizar(UsuarioDto usuarioParaActulizar) {
		
		try {
			UsuarioEntidad usuarioEntidadParaActulizar = new UsuarioEntidad();		
			String objetoJson = mapper.writeValueAsString(usuarioParaActulizar);		
			usuarioEntidadParaActulizar = mapper.readValue(objetoJson, UsuarioEntidad.class);		
			
			Optional<UsuarioEntidad> optUsuarioEntidadRespuesta = usuarioDal.actualizar(usuarioEntidadParaActulizar);
			if(optUsuarioEntidadRespuesta.isPresent()) {
				
				UsuarioEntidad usuarioActualizado = optUsuarioEntidadRespuesta.get();
				objetoJson = mapper.writeValueAsString(usuarioActualizado);
				UsuarioDto usuarioDtoActulizado = mapper.readValue(objetoJson, UsuarioDto.class);
				
				/*ResultadoUsuarioDto respuestaExistosa = new ResultadoUsuarioDto();
				respuestaExistosa.setOk(true);
				respuestaExistosa.setUsuario(usuarioDtoActulizado);*/
				//ResultadoUsuarioDto respuestaExistosa = ResultadoUsuarioDto.todoOk(usuarioDtoActulizado);
				/*ResultadoDto<UsuarioDto> respuestaExistosa = new ResultadoDto<UsuarioDto>();
				respuestaExistosa.setOk(true);
				respuestaExistosa.setDatos(usuarioDtoActulizado);*/
				ResultadoDto<UsuarioDto> respuestaExistosa = ResultadoDto.<UsuarioDto>ok(usuarioDtoActulizado);
				respuestaExistosa.setMensaje("USUARIO ACTUALIZADO CORRECTAMENTE");
				return respuestaExistosa;
			} else {
				/*ResultadoUsuarioDto respuestaFallida = new ResultadoUsuarioDto();
				respuestaFallida.setOk(false);
				respuestaFallida.setMensaje("EL USUARIO BUSCADO NO EXISTE!!!");*/
				//ResultadoUsuarioDto respuestaFallida = ResultadoUsuarioDto.todoMal("EL USUARIO BUSCADO NO EXISTE!!!");
				
				
				
				/*ResultadoDto<UsuarioDto> respuestaFallida = new ResultadoDto<UsuarioDto>();
				respuestaFallida.setOk(false);
				respuestaFallida.setMensaje("EL USUARIO NO EXISTE!!!!");*/
				
				ResultadoDto<UsuarioDto> respuestaFallida = ResultadoDto.<UsuarioDto>todoMal("UsuarioNoExiste");
				
				return respuestaFallida;
			}
	    } catch(JsonProcessingException e) {
	        return ResultadoDto.<UsuarioDto>todoMal("Las propiedades no pudieron ser asignadas");
	    } catch(Exception e) {
	        return ResultadoDto.<UsuarioDto>todoMal(e.toString());  
	    }
		
		
		
	}
	
	public ResultadoDto<UsuarioDto> obtenerUnUsuario(int id) {
		Optional<UsuarioEntidad> optUsuarioEntidad = usuarioDal.obtenerPorId(id);
		
		if(optUsuarioEntidad.isPresent()) {
			UsuarioEntidad usuarioEntidad = optUsuarioEntidad.get();
			UsuarioDto usuarioDtoEncontrado = new UsuarioDto();
			usuarioDtoEncontrado.setId(usuarioEntidad.getId());
			usuarioDtoEncontrado.setNombre(usuarioEntidad.getNombre());
			usuarioDtoEncontrado.setApellido(usuarioEntidad.getApellido());
			usuarioDtoEncontrado.setDireccion(usuarioEntidad.getDireccion());
			usuarioDtoEncontrado.setTelefono(usuarioEntidad.getTelefono());
			return ResultadoDto.<UsuarioDto>ok(usuarioDtoEncontrado);
		}
		return ResultadoDto.<UsuarioDto>todoMal("Usuario no encontrado");
		
	}
	
	public ResultadoDto<List<UsuarioDto>> obtenerPorApellido(String apellido) {
		try {
			List<UsuarioEntidad> listaUsuarioEntidad  = usuarioDal.consultarPorApellido(apellido);
			List<UsuarioDto> listaUsuarioDto = new ArrayList<UsuarioDto>();
			
			listaUsuarioDto = 
					Arrays.asList(mapper.readValue(mapper.writeValueAsString(listaUsuarioEntidad),UsuarioDto[].class));

			return ResultadoDto.<List<UsuarioDto>>ok(listaUsuarioDto);
	    } catch(JsonProcessingException e) {
	        return ResultadoDto.<List<UsuarioDto>>todoMal("Las propiedades no pudieron ser asignadas");
	    } catch(Exception e) {
	        return ResultadoDto.<List<UsuarioDto>>todoMal(e.toString());  
	    }		
	}
	
	
}
