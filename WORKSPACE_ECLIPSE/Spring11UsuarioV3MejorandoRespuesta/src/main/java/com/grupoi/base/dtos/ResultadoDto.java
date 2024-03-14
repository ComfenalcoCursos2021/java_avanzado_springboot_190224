package com.grupoi.base.dtos;

public class ResultadoDto<T> {
	private boolean ok;
	private T datos;
	private String mensaje;
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
