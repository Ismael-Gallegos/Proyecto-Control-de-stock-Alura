package com.alura.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.dao.CategoriaDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		// Crear un nuevo controlador de categorías al inicializar
		var factory = new ConnectionFactory();
		this.categoriaDAO = new CategoriaDAO(factory.recuperaConexion()); 	
	}
	
	// Método para obtener una lista de todas las categorías
	public List<Categoria> listar() {
		return categoriaDAO.listar();
	}

	// Método para obtener una lista de categorías con productos (para el reporte)
    public List<Categoria> cargaReporte() {
        return this.categoriaDAO.listarConProductos();
    }
}
