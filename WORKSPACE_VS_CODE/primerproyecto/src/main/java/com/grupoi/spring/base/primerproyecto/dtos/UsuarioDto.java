package com.grupoi.spring.base.primerproyecto.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UsuarioDto {
    private String nombre;
    private String apellido;
    private String version;

    public UsuarioDto(String valorNombre, String valorApellido){
        nombre = valorNombre;
        apellido = valorApellido;
        version = "1.0";
    }
    

    
}
