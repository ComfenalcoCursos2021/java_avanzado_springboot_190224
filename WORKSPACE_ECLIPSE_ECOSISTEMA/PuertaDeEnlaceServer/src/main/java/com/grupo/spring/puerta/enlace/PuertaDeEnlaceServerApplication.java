package com.grupo.spring.puerta.enlace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PuertaDeEnlaceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuertaDeEnlaceServerApplication.class, args);
	}

}
