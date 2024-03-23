package com.grupo.spring.administrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdministradorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministradorServerApplication.class, args);
	}

}
