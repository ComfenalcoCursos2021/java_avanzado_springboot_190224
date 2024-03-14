package com.grupoi.base.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoi.base.entidades.ClasificacionEntidad;
import com.grupoi.base.repositorios.IClasificacionRepositorio;


@Service
public class ClasificacionDal {

	@Autowired
	private IClasificacionRepositorio repositorio;
	
	public List<ClasificacionEntidad> buscarTodos(){
		return this.repositorio.findAll();
	}
	
	public ClasificacionEntidad buscarPorId(int id) {
		return this.repositorio.findById(id).get();
	}
	public ClasificacionEntidad actualizar(ClasificacionEntidad entidad) {
		
		var entidadActualizar = this.repositorio.findById(entidad.getId()).get();
		
		entidadActualizar.setNombre(entidad.getNombre());
		
		this.repositorio.save(entidadActualizar);
		return entidadActualizar;
	}
	
	public ClasificacionEntidad guardar(ClasificacionEntidad nuevo) {
		ClasificacionEntidad registroGuardado =  this.repositorio.save(nuevo);
		return registroGuardado;
	}
}
