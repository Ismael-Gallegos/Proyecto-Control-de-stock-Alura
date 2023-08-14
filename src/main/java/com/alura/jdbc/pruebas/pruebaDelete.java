package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.jdbc.factory.ConnectionFactory;

public class pruebaDelete {
    public static void main(String[] args) throws SQLException {
        // Recupera una conexión del pool de conexiones
        Connection con = new ConnectionFactory().recuperaConexion();
        
        // Crea una declaración SQL
        Statement statement = con.createStatement();
        
        // Ejecuta una sentencia DELETE en la base de datos para eliminar un registro
        statement.execute("DELETE FROM PRODUCTO WHERE ID = 99");
        
        // Imprime la cantidad de filas afectadas por la sentencia DELETE
        System.out.println(statement.getUpdateCount());
        
        // Cierra la conexión
        con.close();
    }
}

