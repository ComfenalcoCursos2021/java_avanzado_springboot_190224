package com.grupo.spring.producto.dtos;

public class ResultadoDto<T> {
	private boolean ok;
	private T datos;
	private String mensaje;
	
	
	public static <T> ResultadoDto<T> ok(T data){
		ResultadoDto<T> nuevo = new ResultadoDto<T>();
		nuevo.datos = data;
		nuevo.ok = true;
		return nuevo;		
	}
	public static <T> ResultadoDto<T> todoMal(String mensaje){
		ResultadoDto<T> nuevo = new ResultadoDto<T>();
		nuevo.mensaje = mensaje;
		nuevo.ok = false;
		return nuevo;		
	}
	
	
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public T getDatos() {
		return datos;
	}
	public void setDatos(T datos) {
		this.datos = datos;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
	
}

