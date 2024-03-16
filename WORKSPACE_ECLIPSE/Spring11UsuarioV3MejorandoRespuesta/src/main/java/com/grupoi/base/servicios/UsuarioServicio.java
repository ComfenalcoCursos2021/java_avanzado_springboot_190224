package com.grupoi.base.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoi.base.dal.UsuarioDal;
import com.grupoi.base.dtos.ClasificacionDto;
import com.grupoi.base.dtos.ResultadoDto;
import com.grupoi.base.dtos.ResultadoUsuarioDto;
import com.grupoi.base.dtos.UsuarioDto;
import com.grupoi.base.entidades.UsuarioEntidad;

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioDal usuarioDal;
	
	public ResultadoDto<UsuarioDto> guardarUsuario(UsuarioDto usuarioDto) {
		
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
		
		return ResultadoDto.<UsuarioDto>ok(usuarioDtoGuardado);
	}
	
	public ResultadoDto<List<UsuarioDto>> obtenerTodos() {
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
		return ResultadoDto.<List<UsuarioDto>>ok(listaUsuarioDto);
		
	}
	public boolean borrar(int idParaBorrar) {
		boolean respuesta = usuarioDal.borrar(idParaBorrar);
		return respuesta;
	}
	
	public ResultadoDto<UsuarioDto> actualizar(UsuarioDto usuarioParaActulizar) {
		
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
		
		
	}
	
	public ResultadoDto<UsuarioDto> obtenerUnUsuario(int id) {
		UsuarioEntidad usuarioEntidad = usuarioDal.obtenerPorId(id);
		
		if(usuarioEntidad != null) {
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
	
	
}
