package com.grupo.spring.conexion;

public class ConexionMySql implements IConexion {

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
