package com.grupoi.base.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grupoi.base.dal.interfaces.IDatosMemoria;
import com.grupoi.base.dtos.ClasificacionDto;

@Repository
public class SuperMercadoDB implements IDatosMemoria {

	private List<ClasificacionDto> lista;

	public SuperMercadoDB() {
		lista = new ArrayList<ClasificacionDto>();
		lista.add(ClasificacionDto.builder().id(1).nombre("Electrodomesticos").build());
		lista.add(ClasificacionDto.builder().id(2).nombre("Jugueteria").build());
		lista.add(ClasificacionDto.builder().id(3).nombre("Licores").build());
	}

	@Override
	public List<ClasificacionDto> listarTodos() {
		return this.lista;
	}

	@Override
	public ClasificacionDto agregar(ClasificacionDto nuevo) {
		int nuevoId = 0;
		if (!this.lista.isEmpty()) {
			nuevoId = this.lista.stream().mapToInt(ClasificacionDto::getId).max().getAsInt();
		}

		var clasificacion = ClasificacionDto.builder().nombre(nuevo.getNombre()).id(nuevoId + 1).build();

		lista.add(clasificacion);
		return clasificacion;
	}

}
