package com.grupoi.base.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.dtos.UsuarioDto;


@RestController
@RequestMapping("")
public class PruebaControlador {

	@GetMapping("getdesdeeclipse")
	public UsuarioDto getPrimero() {
		var usuario = UsuarioDto.builder()
				.nombre("Pepito")
				.apellido("Perez")
				.version("1.0 Eclipse")
				.build();
		return usuario;
	}
	
}
