package com.grupoi.base.dtos;

public class ResultadoUsuarioDto {

	private boolean ok;
	private UsuarioDto usuario;
	private String mensaje;
	
	public boolean isOk() {
		return ok;
	}
	
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public UsuarioDto getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public static ResultadoUsuarioDto todoOk(UsuarioDto usuario) {
		ResultadoUsuarioDto nuevo = new ResultadoUsuarioDto();
		nuevo.ok = true;
		nuevo.usuario = usuario;
		return nuevo;
	}
	public static ResultadoUsuarioDto todoMal(String mensaje) {
		ResultadoUsuarioDto nuevo = new ResultadoUsuarioDto();
		nuevo.ok = false;
		nuevo.mensaje = mensaje;
		return nuevo;
	}
}
