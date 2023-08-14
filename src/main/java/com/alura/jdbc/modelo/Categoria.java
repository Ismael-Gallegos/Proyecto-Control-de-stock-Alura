package com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nombre;
	private List<Producto> productos;
	
	// Constructor de la clase, recibe el ID y el nombre de la categoría
	public Categoria(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	// Método para obtener el ID de la categoría
	public Integer getId() {
		return this.id;
	}
	
	// Sobrescritura del método toString para representar la categoría con su nombre
	@Override
	public String toString() {
		return this.nombre;
	}

	// Método para agregar un producto a la lista de productos de la categoría
	public void agregar(Producto producto) {
		if (this.productos == null) {
			this.productos = new ArrayList<>();
		}
		
		this.productos.add(producto);
	}

	// Método para obtener la lista de productos asociados a la categoría
	public List<Producto> getProductos() {
		return this.productos;
	}
}
