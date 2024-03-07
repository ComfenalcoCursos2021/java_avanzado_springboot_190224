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
	
	public ClasificacionEntidad guardar(ClasificacionEntidad nuevo) {
		return this.repositorio.save(nuevo);
	}
}
