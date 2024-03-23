package com.grupo.spring.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistroServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroServerApplication.class, args);
	}

}
