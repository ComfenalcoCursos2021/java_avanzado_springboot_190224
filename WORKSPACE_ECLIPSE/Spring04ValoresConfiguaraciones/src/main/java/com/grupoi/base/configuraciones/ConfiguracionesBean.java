package com.grupoi.base.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.grupoi.base.excepciones.ErrorTipoConexionExcepcion;
import com.grupoi.base.falsabase.BaseFerreteria;
import com.grupoi.base.falsabase.BaseSupermercado;
import com.grupoi.base.falsabase.IBaseDatosMemoria;

@Configuration
public class ConfiguracionesBean {

	@Value("${grupo.spring.tipoconexion}")
	private String tipoConexion;
	
	@Autowired
	private Environment env;
	
	@Bean
	public IBaseDatosMemoria crearBaseFalsaInstancia() throws ErrorTipoConexionExcepcion {		
		
		if("FERRETERIA".equals(tipoConexion != null ? tipoConexion.toUpperCase() : "")) {
			return new BaseFerreteria();
		} else if ("SUPERMERCADO".equals(tipoConexion != null ? tipoConexion.toUpperCase() : "")) {
			return new BaseSupermercado();			
		}
		throw new ErrorTipoConexionExcepcion(env.getProperty("ErrorTipoConexionExcepcion"));
		
	}
}
