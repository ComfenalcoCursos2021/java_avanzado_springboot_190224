package com.grupoi.base.falsabase;

import java.util.ArrayList;
import java.util.List;

import com.grupoi.base.dto.ClasificacionDto;

public class BaseFalsa {

	private List<ClasificacionDto> lista;
	
	public BaseFalsa (){
		lista = new ArrayList<ClasificacionDto>();
		lista.add(ClasificacionDto.builder().id(1).nombre("Electrodomesticos").build());
		lista.add(ClasificacionDto.builder().id(2).nombre("Jugueteria").build());
		lista.add(ClasificacionDto.builder().id(3).nombre("Licores").build());
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
