package com.grupoi.base.dto;

public class ResultadoDto {
	private boolean exitoso;
	private String mensaje;
	public boolean isExitoso() {
		return exitoso;
	}
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
}
