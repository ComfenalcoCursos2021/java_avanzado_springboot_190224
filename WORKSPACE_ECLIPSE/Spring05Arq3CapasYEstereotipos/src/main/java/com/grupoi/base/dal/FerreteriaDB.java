package com.grupoi.base.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.grupoi.base.dal.interfaces.IDatosMemoria;
import com.grupoi.base.dtos.ClasificacionDto;

@Component
//@Primary
public class FerreteriaDB implements IDatosMemoria {
private List<ClasificacionDto> lista;
	
	public FerreteriaDB (){
		lista = new ArrayList<ClasificacionDto>();
		lista.add(ClasificacionDto.builder().id(1).nombre("Plomeria").build());
		lista.add(ClasificacionDto.builder().id(2).nombre("Maquinaria").build());
		lista.add(ClasificacionDto.builder().id(3).nombre("Pinturas").build());
	}
	
	@Override
	public List<ClasificacionDto> listarTodos(){
		return this.lista;
	}
	@Override
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
