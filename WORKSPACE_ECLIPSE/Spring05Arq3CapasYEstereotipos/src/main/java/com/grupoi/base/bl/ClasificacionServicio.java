package com.grupoi.base.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.grupoi.base.dal.interfaces.IDatosMemoria;
import com.grupoi.base.dtos.ClasificacionDto;

@Component
public class ClasificacionServicio {

	@Autowired
	@Qualifier("ferreteriaDB")
	private IDatosMemoria laBaseDeDatos;
	
	public List<ClasificacionDto> obtenerTodos(){
		return laBaseDeDatos.listarTodos();
	}
	
	public ClasificacionDto crear(ClasificacionDto nuevo) {
		return laBaseDeDatos.agregar(nuevo);
	}
}
