package com.grupo.spring.logueo.controladores;

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

import com.grupo.spring.logueo.dtos.LoginDto;
import com.grupo.spring.logueo.dtos.ResultadoDto;
import com.grupo.spring.logueo.servicios.LoginServicio;

@RestController
@RequestMapping("/api/tablalogin")
public class LoginControlador {
	@Autowired
	private LoginServicio servicio;
	
	@GetMapping()
	public ResultadoDto<List<LoginDto>> obtenerTodos() {
		return servicio.obtenerTodos();
	}
	@GetMapping("/{id}")
	public ResultadoDto<LoginDto> obtenerPorId(@PathVariable int id) {
		return servicio.obtenerPorId(id);
	}
	@PostMapping()
	public ResultadoDto<LoginDto> guardar(@RequestBody LoginDto dto) {
		return servicio.guardar(dto);
	}
	@PutMapping("/{id}")
	public ResultadoDto<LoginDto> actualizar(@PathVariable int id, @RequestBody LoginDto dto) {
		dto.setId(id);
		return servicio.actualizar(dto);		
	}
	@DeleteMapping("/{id}")
	public ResultadoDto<Boolean> borrar(@PathVariable int id) {		
		return servicio.borrar(id);		
	}

}
