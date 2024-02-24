package com.grupo.spring.principal;

import com.grupo.spring.clases.dtos.UsuarioDto;
import com.grupo.spring.clases.singleton.Mensajes;

public class Main {

	public static void main(String[] args) {
		System.out.println("Saludo");
		
		
		Mensajes nueva = Mensajes.getInstancia();
		nueva.setElMensaje("el nueva");
		Mensajes nueva2 = Mensajes.getInstancia();
		nueva2.setElMensaje("El nueva2");
		
		
		System.out.println("==========================");
		System.out.println(nueva.getElMensaje());
		System.out.println(nueva2.getElMensaje());
		
		
		System.out.println("==========================");
		
		UsuarioDto a = UsuarioDto.builder().nombre("el nombre").build();
		
		System.out.println("Termino!!!");
	}

}
