package com.grupo.spring.principal;

import com.grupo.spring.conexion.ConexionMySql;
import com.grupo.spring.conexion.ConexionSqlServer;
import com.grupo.spring.conexion.IConexion;
import com.grupo.spring.configuraciones.ConfiguracionesGlobales;
import com.grupo.spring.fabrica.FabricaConexiones;

public class Lanzador {

	public static void main(String[] args) {
		//ConexionMySql conn = new ConexionMySql();
		//ConexionSqlServer conn = new ConexionSqlServer();
		
		IConexion conn = 
				FabricaConexiones.crearInstanciaConexion(ConfiguracionesGlobales.TIPO_CONEXION);
		
		conn.conectar();
		conn.borrar();
		
		conn.insertar();
		conn.insertar();
		conn.borrar();		
		
		System.out.println("Termino !!!!");

	}

}
