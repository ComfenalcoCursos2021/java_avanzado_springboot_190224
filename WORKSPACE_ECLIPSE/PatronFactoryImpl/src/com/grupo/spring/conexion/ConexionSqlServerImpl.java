package com.grupo.spring.conexion;

public class ConexionSqlServerImpl implements Conexion {

	@Override
	public void conectar() {
		System.out.println("CONECTANDO CON SQL SERVER");
		
	}

	@Override
	public void insertar() {
		System.out.println("INSERTANDO CON SQL SERVER");
		
	}

	@Override
	public void borrar() {
		System.out.println("BORRANDO CON SQL SERVER");
		
	}

}
