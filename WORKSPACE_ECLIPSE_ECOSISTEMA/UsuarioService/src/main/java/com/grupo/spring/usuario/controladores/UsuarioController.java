package com.grupo.spring.usuario.controladores;

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

import com.grupo.spring.usuario.dtos.UsuarioDto;
import com.grupo.spring.usuario.dtos.ResultadoDto;
import com.grupo.spring.usuario.servicios.UsuarioServicio;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping()
	public ResultadoDto<List<UsuarioDto>> obtenerTodos() {
		return servicio.obtenerTodos();
	}
	@GetMapping("/{id}")
	public ResultadoDto<UsuarioDto> obtenerPorId(@PathVariable int id) {
		return servicio.obtenerPorId(id);
	}
	@PostMapping()
	public ResultadoDto<UsuarioDto> guardar(@RequestBody UsuarioDto dto) {
		return servicio.guardar(dto);
	}
	@PutMapping("/{id}")
	public ResultadoDto<UsuarioDto> actualizar(@PathVariable int id, @RequestBody UsuarioDto dto) {
		dto.setId(id);
		return servicio.actualizar(dto);		
	}
	@DeleteMapping("/{id}")
	public ResultadoDto<Boolean> borrar(@PathVariable int id) {		
		return servicio.borrar(id);		
	}
}
