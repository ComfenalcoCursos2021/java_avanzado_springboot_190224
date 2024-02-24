package com.grupoi.base.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioControlador {

	@GetMapping("getdesdeeclipsepagina")
	public String getMethodName() {
		return "pagina";
	}
	
}
