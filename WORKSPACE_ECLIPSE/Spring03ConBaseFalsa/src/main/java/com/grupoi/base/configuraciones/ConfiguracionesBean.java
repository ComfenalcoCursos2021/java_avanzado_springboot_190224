package com.grupoi.base.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grupoi.base.dto.ClasificacionDto;
import com.grupoi.base.falsabase.BaseFalsa;

@Configuration
public class ConfiguracionesBean {

	@Bean
	public BaseFalsa crearBaseFalsaInstancia() {
		
		var b = new BaseFalsa();
		for (int i = 0; i < 10; i++) {
			b.agregar(ClasificacionDto
					.builder()
					.id(i+10)
					.nombre("NombreClasificacion"+i)
					.build());
		}
		return b;
	}
}
