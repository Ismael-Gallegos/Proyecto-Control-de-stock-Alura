package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        // Recupera una conexión del pool de conexiones
    	Connection con = new ConnectionFactory().recuperaConexion();

        // Imprime un mensaje para indicar que la conexión se cerrará
        System.out.println("Cerrando la conexión");

        // Cierra la conexión
        con.close();
    }
}

