package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaPoolDeConexiones {
	
	public static void main(String[] args) throws SQLException {
		// Creación de la instancia ConnectionFactory: Aquí se crea un objeto de la clase ConnectionFactory, que administrará el pool de conexiones.
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		// Bucle for: Aquí comienza un bucle que se ejecutará 20 veces.
		for (int i = 0; i < 20; i++) {
			// Obtención de la conexión: En cada iteración, se obtiene una conexión de la fábrica de conexiones mediante el método recuperaConexion().
			Connection con = connectionFactory.recuperaConexion();
			
			// Impresión del número de conexión: Se imprime en la consola un mensaje que indica el número de la conexión que se está abriendo.
			System.out.println("Abriendo la conexión de número " + (i + 1));
		}
	}
}
