package com.grupoi.spring.base.primerproyecto.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoi.spring.base.primerproyecto.dtos.UsuarioDto;


@RestController
@RequestMapping("/api")
public class PruebaControlador {

    @GetMapping("primeraprueba")
    public UsuarioDto getPrimeraPrueba() {
        
        var usuario = UsuarioDto.builder()
        .apellido("Perez")
        .nombre("Pepito")
        .version("3.0").build();
        
        return usuario;
    }
    

}
