package com.grupo.spring.producto.dal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo.spring.producto.entidades.ProductoEntidad;
import com.grupo.spring.producto.repositorios.IProductoRepositorio;

@Service
public class ProductoDal {

	@Autowired
	IProductoRepositorio repositorio;
	
	public List<ProductoEntidad> obtenerTodos() {		
		return repositorio.findAll();
	}
	
	public Optional<ProductoEntidad> obtenerPorId(int id) {
		return repositorio.findById(id);
	}
	
	public ProductoEntidad guardar(ProductoEntidad entidad) {
		return repositorio.save(entidad);
	}
	
	public Optional<ProductoEntidad> actualizar(ProductoEntidad entidadActualizar) {
		
		Optional<ProductoEntidad> entidadEncontrada = repositorio.findById(entidadActualizar.getId());
		if(entidadEncontrada.isPresent()) {
			ProductoEntidad entidad = entidadEncontrada.get();
			entidad.setDescripcion(entidadActualizar.getDescripcion());
			entidad.setUnidad(entidadActualizar.getUnidad());
			entidad.setPrecio(entidadActualizar.getPrecio());
			return Optional.of(repositorio.save(entidad));
			
		}
		return Optional.empty();
	}
	public boolean borrar(int id) {		
		if(repositorio.existsById(id)) {
			repositorio.deleteById(id);
			return true;
		}
		return false;
	}
}
