package com.grupo.spring.fabrica;

import com.grupo.spring.conexion.ConexionMySql;
import com.grupo.spring.conexion.ConexionSqlServer;
import com.grupo.spring.conexion.IConexion;
import com.grupo.spring.configuraciones.ETipoConexion;

public class FabricaConexiones {

	public static IConexion crearInstanciaConexion(ETipoConexion tipo) {
		if(tipo.equals(ETipoConexion.MySQL)) {
			return new ConexionMySql();
		} else if(tipo.equals(ETipoConexion.SQLServer)) {
			return new ConexionSqlServer();
		}
		return new ConexionMySql();
		
	}
}
