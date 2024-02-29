package com.grupoi.base.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.dto.ClasificacionDto;
import com.grupoi.base.falsabase.BaseFalsa;

@RestController
@RequestMapping("api")
public class ClasificacionControlador {

	public BaseFalsa baseDatos = new BaseFalsa();

	@GetMapping("clasificacion")
	public List<ClasificacionDto> getClasificacion() {		
		return baseDatos.obtenerTodos();
	}

	
	@PostMapping("clasificacion")
	public ClasificacionDto crearMultiple(@RequestBody ClasificacionDto elNuevo) {
		var clasificacion = baseDatos.agregar(elNuevo);
		return clasificacion;
	}


}
