package com.grupoi.base.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.grupoi.base.dal.ClasificacionDal;
import com.grupoi.base.dal.interfaces.IDatosMemoria;
import com.grupoi.base.dtos.ClasificacionDto;
import com.grupoi.base.entidades.ClasificacionEntidad;

@Service
public class ClasificacionServicio {

	@Autowired
	@Qualifier("superMercadoDB") 
	private IDatosMemoria laBaseDeDatos;
	
	@Autowired
	private ClasificacionDal clasificacionDal;
	
	public List<ClasificacionDto> obtenerTodos(){
		List<ClasificacionDto> lista = new ArrayList<ClasificacionDto>();
		var listaEntidades = clasificacionDal.buscarTodos();
		
		for (ClasificacionEntidad elemento : listaEntidades) {
			var nuevo = ClasificacionDto.builder().id(elemento.getId())
					.nombre(elemento.getNombre()).build();
			
			lista.add(nuevo);		
		}
		
		
		return lista;
	}
	
	public ClasificacionDto crear(ClasificacionDto nuevo) {
		var entidad = new ClasificacionEntidad();
		entidad.setId(0);
		entidad.setNombre(nuevo.getNombre());
		entidad.setIdUsuarioModificador(5);
		entidad.setUsuarioModificador("Pepito");
		entidad.setUltimaActualizacion(new Date());
		
		entidad = this.clasificacionDal.guardar(entidad);
		nuevo.setId(entidad.getId());
		return nuevo;
	}
}
