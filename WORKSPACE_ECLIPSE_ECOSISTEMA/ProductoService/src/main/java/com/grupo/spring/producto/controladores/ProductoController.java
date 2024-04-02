package com.grupo.spring.producto.controladores;

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

import com.grupo.spring.producto.dtos.ProductoDto;
import com.grupo.spring.producto.dtos.ResultadoDto;
import com.grupo.spring.producto.dtos.UsuarioDto;
import com.grupo.spring.producto.servicios.ProductoServicio;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	@Autowired
	private ProductoServicio servicio;
	
	
	
	@GetMapping()
	public ResultadoDto<List<ProductoDto>> obtenerTodos() {
		return servicio.obtenerTodos();
	}
	@GetMapping("/{id}")
	public ResultadoDto<ProductoDto> obtenerPorId(@PathVariable int id) {
		return servicio.obtenerPorId(id);
	}
	@PostMapping()
	public ResultadoDto<ProductoDto> guardar(@RequestBody ProductoDto dto) {
		return servicio.guardar(dto);
	}
	@PutMapping("/{id}")
	public ResultadoDto<ProductoDto> actualizar(@PathVariable int id, @RequestBody ProductoDto dto) {
		dto.setId(id);
		return servicio.actualizar(dto);		
	}
	@DeleteMapping("/{id}")
	public ResultadoDto<Boolean> borrar(@PathVariable int id) {		
		return servicio.borrar(id);		
	}
	
	@GetMapping("/listarUsuarios")
	public ResultadoDto<List<UsuarioDto>> obtenerTodosLosUsuarios() {
		return servicio.obtenerTodosLosUsuarios();
	}
	
}
