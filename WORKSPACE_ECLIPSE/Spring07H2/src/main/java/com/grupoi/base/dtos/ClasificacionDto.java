package com.grupoi.base.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClasificacionDto {
	private int id;
	private String nombre;
	
}
