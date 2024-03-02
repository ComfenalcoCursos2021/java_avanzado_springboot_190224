package com.grupoi.base.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/echoconf")
public class EchoConfiguracionesControlador {
	
	@Value("${grupo.spring.formatofecha}")
	private String formatoFecha;
	
	@Value("${grupo.spring.tipoconexion}")
	private String tipoConexion;
	
	@Value("${grupo.spring.colorers.permitidos}")
	private String coloresPermitidos;
	
	@Value("#{    '${grupo.spring.colorers.permitidos}'.split('-')   }")
	private String[] coloresPermitidos2;
	
	@Value("${grupo.spring.valor.membresia}")
	private int valorMembresia;
	
	
	@Value("#{${grupo.spring.login}}")
	private Map<String,Object> login;
	
	
	@GetMapping()
	public Map<String,Object> getMethodName() {
		
		var mapa = new HashMap<String,Object>();
		mapa.put("Conexion", tipoConexion);
		mapa.put("FormatoFecha", formatoFecha);
		mapa.put("ColoresPermitidos", coloresPermitidos);		
		mapa.put("ColoresPermitidos2", coloresPermitidos2);	
		String[] coloresPermitidos3 = coloresPermitidos.split("-");
		mapa.put("ColoresPermitidos3", coloresPermitidos3);
		mapa.put("ValorMembresia", valorMembresia);
		mapa.put("Login", login);
		return mapa;
	}
	

}
