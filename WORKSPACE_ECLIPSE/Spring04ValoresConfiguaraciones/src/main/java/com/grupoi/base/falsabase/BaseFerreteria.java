package com.grupoi.base.falsabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.grupoi.base.dto.ClasificacionDto;


//@Component
public class BaseFerreteria implements IBaseDatosMemoria {

	private List<ClasificacionDto> lista;
	
	public BaseFerreteria (){
		lista = new ArrayList<ClasificacionDto>();
		lista.add(ClasificacionDto.builder().id(1).nombre("Plomeria").build());
		lista.add(ClasificacionDto.builder().id(2).nombre("Maquinaria").build());
		lista.add(ClasificacionDto.builder().id(3).nombre("Pinturas").build());
	}
	
	public List<ClasificacionDto> obtenerTodos(){
		return this.lista;
	}
	
	public ClasificacionDto agregar(ClasificacionDto elNuevo) {
		int nuevoId = 0;
		if (!this.lista.isEmpty()) {
			nuevoId = this.lista.stream().mapToInt(ClasificacionDto::getId).max().getAsInt();
		}

		var clasificacion = ClasificacionDto.builder()
				.nombre(elNuevo.getNombre())
				.id(nuevoId + 1)
				.build();
		
		lista.add(clasificacion);
		return clasificacion;
	}
}
