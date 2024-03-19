package com.grupoi.base.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.dtos.ResultadoDto;
import com.grupoi.base.dtos.ResultadoUsuarioDto;
import com.grupoi.base.dtos.UsuarioDto;
import com.grupoi.base.servicios.UsuarioServicio;






@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@PostMapping
	public ResultadoDto<UsuarioDto> guardarUsuario(@RequestBody UsuarioDto usuarioDto) {
		ResultadoDto<UsuarioDto> resultadoUsuarioDtoGuardado = usuarioServicio.guardarUsuario(usuarioDto);
		return resultadoUsuarioDtoGuardado;
	}
	
	@GetMapping()
	public ResultadoDto<List<UsuarioDto>> obtenerTodosLosUsuarios() {
		ResultadoDto<List<UsuarioDto>> resultadoListaUsuarioDto = usuarioServicio.obtenerTodos();
		return resultadoListaUsuarioDto;
	}
	
	@DeleteMapping("/{idParaBorrar}")
	public ResultadoDto<Boolean> borrarUsuario(@PathVariable int idParaBorrar) {
		ResultadoDto<Boolean> respuesta = usuarioServicio.borrar(idParaBorrar);
		return respuesta;
	}
	
	@PutMapping("/{id}")
	public ResultadoDto<UsuarioDto> actualizarUsuario(@PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
		usuarioDto.setId(id);
		ResultadoDto<UsuarioDto> usuarioResultadoDto = usuarioServicio.actualizar(usuarioDto);
		
		return usuarioResultadoDto;
	}
	@GetMapping("/{id}")
	public ResultadoDto<UsuarioDto> getMethodName(@PathVariable int id) {
		ResultadoDto<UsuarioDto> usuarioEncontrado = usuarioServicio.obtenerUnUsuario(id);
		return usuarioEncontrado;
	}
	
	@GetMapping("buscador/{texto}")
	public ResultadoDto<List<UsuarioDto>> obtenerTodosLosUsuarios(@PathVariable String texto) {
		ResultadoDto<List<UsuarioDto>> resultadoListaUsuarioDto = usuarioServicio.obtenerPorApellido(texto);
		return resultadoListaUsuarioDto;
	}
	
	
	
}
