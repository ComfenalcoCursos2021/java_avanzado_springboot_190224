package com.grupoi.base.dal.interfaces;

import java.util.List;

import com.grupoi.base.dtos.ClasificacionDto;

public interface IDatosMemoria {

	List<ClasificacionDto> listarTodos();
	ClasificacionDto agregar(ClasificacionDto nuevo);
}
