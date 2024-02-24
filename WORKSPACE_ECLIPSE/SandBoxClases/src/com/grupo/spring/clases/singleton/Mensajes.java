package com.grupo.spring.clases.singleton;

public class Mensajes {
	
	private String elMensaje;
	private static Mensajes instancia;

	private Mensajes() {
		System.out.println("ESTA EJECUTANDO EL CONSTRUCTOR");
	}
	
	public static Mensajes getInstancia() {		
		if(instancia == null) {
			instancia = new Mensajes();
		}		
		return instancia;
	}

	public String getElMensaje() {
		return elMensaje;
	}

	public void setElMensaje(String elMensaje) {
		this.elMensaje = elMensaje;
	}
	
	
}
