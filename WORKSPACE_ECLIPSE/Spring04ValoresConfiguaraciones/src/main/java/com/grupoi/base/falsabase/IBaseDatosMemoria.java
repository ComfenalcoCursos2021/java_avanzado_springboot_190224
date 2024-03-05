package com.grupoi.base.falsabase;

import java.util.List;

import com.grupoi.base.dto.ClasificacionDto;

public interface IBaseDatosMemoria {
	List<ClasificacionDto> obtenerTodos();
	ClasificacionDto agregar(ClasificacionDto elNuevo);
}
