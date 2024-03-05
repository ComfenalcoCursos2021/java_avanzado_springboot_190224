package com.grupoi.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.grupoi.base.controladores.ClasificacionControlador;

@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:delproyecto/valores.properties"),
	@PropertySource("classpath:delproyecto/mensajeserror.properties")//,
})
public class Proyecto1VerbosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1VerbosApplication.class, args);		
	}

}
