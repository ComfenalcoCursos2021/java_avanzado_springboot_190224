package com.grupo.spring.clases.dtos;

//@Builder
public class UsuarioDto {
	private String nombre;
	
	
	private static UsuarioDto elObjeto;
	
	public static UsuarioDto builder() {
		elObjeto = new UsuarioDto(); 
		return elObjeto;
	}
	public UsuarioDto nombre(String n) {
		elObjeto.nombre = n;
		return elObjeto;
	}
	
	public UsuarioDto build() {
		return elObjeto;
	}
}
