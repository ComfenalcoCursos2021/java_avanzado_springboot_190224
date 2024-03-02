package com.grupo.spring.conexion;

public class ConexionMySqlImpl implements Conexion {

	@Override
	public void conectar() {
		System.out.println("CONECTANDO CON MYSQL");
	}

	@Override
	public void insertar() {
		System.out.println("INSERTANDO CON MYSQL");
	}

	@Override
	public void borrar() {
		System.out.println("BORRANDO CON MYSQL");
		
	}

}
