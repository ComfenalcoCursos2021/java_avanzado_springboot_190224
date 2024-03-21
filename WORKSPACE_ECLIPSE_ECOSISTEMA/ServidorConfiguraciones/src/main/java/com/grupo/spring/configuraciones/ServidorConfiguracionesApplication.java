package com.grupo.spring.configuraciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServidorConfiguracionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorConfiguracionesApplication.class, args);
	}

}
