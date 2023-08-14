package com.alura.jdbc.controller;

import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

import java.util.List;


public class ProductoController {

	private ProductoDAO productoDAO;
	
	public ProductoController() {
        this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
    }

	// Método para modificar un producto existente en la base de datos
    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        return productoDAO.modificar(nombre, descripcion, cantidad, id);
    }

    // Método para eliminar un producto de la base de datos
    public int eliminar(Integer id) {
        return productoDAO.eliminar(id);
    }

    // Método para listar todos los productos en la base de datos
    public List<Producto> listar() {
        return productoDAO.listar();
    }
    
    // Método para listar productos de una categoría específica
    public List<Producto> listar(Categoria categoria) {
        return productoDAO.listar(categoria.getId());
    }

    // Método para guardar un nuevo producto en la base de datos asociado a una categoría
    public void guardar(Producto producto, Integer categoriaId) {
        producto.setCategoriaId(categoriaId);
        productoDAO.guardad(producto); 
    }
}
