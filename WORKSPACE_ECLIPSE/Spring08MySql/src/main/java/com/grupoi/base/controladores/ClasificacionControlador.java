package com.grupoi.base.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.bl.ClasificacionServicio;
import com.grupoi.base.dtos.ClasificacionDto;

@RestController
@RequestMapping("api/clasificacion")
public class ClasificacionControlador {

	
	private ClasificacionServicio servicio;
	
	public ClasificacionControlador(ClasificacionServicio servicioDesdeSpringBoot) {
		this.servicio = servicioDesdeSpringBoot;		
	}

	@GetMapping()
	public List<ClasificacionDto> getClasificacion() {		
		return servicio.obtenerTodos();
	}

	
	@PostMapping()
	public ClasificacionDto crear(@RequestBody ClasificacionDto elNuevo) {
		return servicio.crear(elNuevo);
	}


}
