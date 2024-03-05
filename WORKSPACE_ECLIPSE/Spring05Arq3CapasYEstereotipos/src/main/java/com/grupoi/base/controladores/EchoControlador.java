package com.grupoi.base.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("api/echo")
public class EchoControlador {

	@GetMapping()
	public String getMethodName(@RequestParam String param) {
		return "Echo desde el echoController " + 
				(new Date()).toString()+
				String.valueOf(param);
	}
	
}
