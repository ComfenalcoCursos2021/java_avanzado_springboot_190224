package com.grupo.spring.producto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.spring.producto.dal.ProductoDal;
import com.grupo.spring.producto.dtos.ProductoDto;
import com.grupo.spring.producto.dtos.ResultadoDto;
import com.grupo.spring.producto.entidades.ProductoEntidad;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoDal dal;	
	private ObjectMapper mapper = new ObjectMapper();	
	
	public ResultadoDto<List<ProductoDto>> obtenerTodos() {		
		List<ProductoDto> lista = mapper.convertValue(dal.obtenerTodos(), List.class);
		return ResultadoDto.ok(lista);
	}
	public ResultadoDto<ProductoDto> obtenerPorId(int id) {
		Optional<ProductoEntidad> entidad = dal.obtenerPorId(id);
		if(entidad.isPresent()) {
			return ResultadoDto.ok(mapper.convertValue(entidad.get(), ProductoDto.class));
		}
		return ResultadoDto.todoMal("No se encontro el producto");
	}
	
	public ResultadoDto<ProductoDto> guardar(ProductoDto dto) {
		
		ProductoEntidad entidad = mapper.convertValue(dto, ProductoEntidad.class);
		ProductoEntidad guardado = dal.guardar(entidad);
		return ResultadoDto.ok(mapper.convertValue(guardado, ProductoDto.class));
	}
	
	public ResultadoDto<ProductoDto> actualizar(ProductoDto dto) {		
		ProductoEntidad entidad = mapper.convertValue(dto, ProductoEntidad.class);
		Optional<ProductoEntidad> entidadActualizada = dal.actualizar(entidad);
		if(entidadActualizada.isPresent()) {
			return ResultadoDto.ok(mapper.convertValue(entidadActualizada.get(), ProductoDto.class));
		}
		return ResultadoDto.todoMal("No se actualizo el producto");		
	}
	
	public ResultadoDto<Boolean> borrar(int id) {
		
		boolean borro = dal.borrar(id);
		return borro ? ResultadoDto.ok(true) : ResultadoDto.todoMal("No se encontro el producto");
	}
}
