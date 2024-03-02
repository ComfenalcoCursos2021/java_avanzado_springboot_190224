package com.grupo.spring.fabrica;

import com.grupo.spring.conexion.ConexionMySqlImpl;
import com.grupo.spring.conexion.ConexionSqlServerImpl;
import com.grupo.spring.conexion.Conexion;
import com.grupo.spring.configuraciones.ETipoConexion;

public class FabricaConexiones {

	public static Conexion crearInstanciaConexion(ETipoConexion tipo) {
		if(tipo.equals(ETipoConexion.MySQL)) {
			return new ConexionMySqlImpl();
		} else if(tipo.equals(ETipoConexion.SQLServer)) {
			return new ConexionSqlServerImpl();
		}
		return new ConexionMySqlImpl();
		
	}
}
