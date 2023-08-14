package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.alura.jdbc.modelo.Producto;

public class ProductoDAO {

    private final Connection con;

    public ProductoDAO(Connection con) {
        this.con = con;
    }

    // Guardar un nuevo producto en la base de datos
    public void guardad(Producto producto) {
        try (con) {
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO PRODUCTO "
                    + "(nombre, descripcion, cantidad, categoria_id) "
                    + " VALUES(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                ejecutaRegistro(producto, statement);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método privado para ejecutar el registro de un producto y obtener su ID generado
    private void ejecutaRegistro(Producto producto, PreparedStatement statement)
            throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setInt(3, producto.getCantidad());
        statement.setInt(4, producto.getCategoriaId());

        statement.execute();

        final ResultSet resultset = statement.getGeneratedKeys();

        try (resultset) {
            while (resultset.next()) {
                producto.setId(resultset.getInt(1));
                System.out.println(
                        String.format(
                                "Fue insertado el Producto %s", producto));
            }
        }
    }

    // Listar todos los productos en la base de datos
    public List<Producto> listar() {
        List<Producto> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con.prepareStatement("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");
            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        Producto fila = new Producto(resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CANTIDAD"));

                        resultado.add(fila);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    // Eliminar un producto de la base de datos por su ID
    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTO WHERE ID = ?");
            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Modificar los detalles de un producto en la base de datos por su ID
    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "UPDATE PRODUCTO SET NOMBRE = ?, "
                + "DESCRIPCION = ?, "
                + "CANTIDAD = ? "
                + "WHERE ID = ?")) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, descripcion);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

            int updateCount = preparedStatement.getUpdateCount();

            return updateCount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Listar productos por ID de categoría
    public List<Producto> listar(Integer categoriaId) {
        List<Producto> resultado = new ArrayList<>();

        try {
            var querySelect = "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD "
                    + " FROM PRODUCTO "
                    + " WHERE CATEGORIA_ID = ?";
            System.out.println(querySelect);
            final PreparedStatement statement = con
                    .prepareStatement(querySelect);

            try (statement) {
                statement.setInt(1, categoriaId);
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        Producto fila = new Producto(resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CANTIDAD"));

                        resultado.add(fila);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
}

