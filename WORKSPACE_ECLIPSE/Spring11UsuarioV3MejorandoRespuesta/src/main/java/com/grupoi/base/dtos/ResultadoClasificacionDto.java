package com.grupoi.base.dtos;

public class ResultadoClasificacionDto {

	private boolean ok;
	private ClasificacionDto clasificacion;
	private String mensaje;
	
	public boolean isOk() {
		return ok;
	}
	
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	
	
	public ClasificacionDto getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionDto clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public static ResultadoClasificacionDto todoOk(ClasificacionDto clasificacion) {
		ResultadoClasificacionDto nuevo = new ResultadoClasificacionDto();
		nuevo.ok = true;
		nuevo.clasificacion = clasificacion;
		return nuevo;
	}
	public static ResultadoClasificacionDto todoMal(String mensaje) {
		ResultadoClasificacionDto nuevo = new ResultadoClasificacionDto();
		nuevo.ok = false;
		nuevo.mensaje = mensaje;
		return nuevo;
	}
}
