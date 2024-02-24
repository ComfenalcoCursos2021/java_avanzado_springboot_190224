package com.grupoi.base.controladores;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.base.dto.ResultadoDto;

@RestController
public class CajaArenaControlador {

	@GetMapping("usuario")
	public ResultadoDto getSaludo() {
		
		ResultadoDto respuesta = new ResultadoDto();
		respuesta.setExitoso(true);
		respuesta.setMensaje("<hr /><h1> obtuvimos los usuarios</h1><hr />");
		return respuesta;
	}
	@PostMapping("usuario")
	public ResultadoDto getSaludoPost() {
		
		ResultadoDto respuesta = new ResultadoDto();
		respuesta.setExitoso(true);
		respuesta.setMensaje("<hr /><h1> creando un usuario</h1><hr />");
		return respuesta;
	}
	
	@PutMapping("usuario")
	public ResultadoDto getSaludoPut() throws Exception {
		
		ResultadoDto respuesta = new ResultadoDto();
		respuesta.setExitoso(true);
		respuesta.setMensaje("<hr /><h1> actualizando un usuario</h1><hr />");
		throw new Exception("algo fallo");
		return respuesta;
	}
	
	@DeleteMapping("usuario")
	public ResultadoDto getSaludoDelete() {
		
		ResultadoDto respuesta = new ResultadoDto();
		respuesta.setExitoso(true);
		respuesta.setMensaje("<hr /><h1> borrando un usuario</h1><hr />");
		return respuesta;
	}
}
