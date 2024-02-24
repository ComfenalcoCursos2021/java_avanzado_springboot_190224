package com.grupoi.base.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioControlador {

	@GetMapping("paginausuario")
	public String getMethodName() {
		return "pagina";
	}
	@GetMapping("paginausuarioclon")
	public String getMethodName2() {
		return "pagina";
	}
	
}
