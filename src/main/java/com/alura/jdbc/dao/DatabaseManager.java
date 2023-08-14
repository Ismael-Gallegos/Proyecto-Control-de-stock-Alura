package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

 // Iniciar una transacción en la base de datos
    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    // Confirmar una transacción en la base de datos
    public void commitTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }

    // Revertir una transacción en la base de datos
    public void rollbackTransaction() {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cerrar la conexión a la base de datos
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ejecutar una consulta de actualización (INSERT, UPDATE, DELETE) en la base de datos
    public void executeUpdate(String query, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.length; i++) {
                preparedStatement.setObject(i + 1, parameters[i]);
            }
            preparedStatement.executeUpdate();
        }
    }
}
