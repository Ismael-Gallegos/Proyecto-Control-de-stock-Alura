package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource datasource;
	
	public ConnectionFactory() {
		// Crear una instancia de ComboPooledDataSource para administrar el pool de conexiones
		var pooledDataSource = new ComboPooledDataSource();
		
		// Configurar la URL de la base de datos, el usuario y la contraseña
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("2410.");
		
		// Establecer el tamaño máximo del pool de conexiones
		pooledDataSource.setMaxPoolSize(10);
		
		// Asignar la instancia de ComboPooledDataSource al atributo datasource de la clase
		this.datasource = pooledDataSource;
	}
	
	/**
	 * Recupera una conexión del pool de conexiones.
	 * 
	 * @return Una instancia de Connection para interactuar con la base de datos.
	 * @throws SQLException Si ocurre un error al establecer la conexión.
	 */
	public Connection recuperaConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
		}
	}
}

