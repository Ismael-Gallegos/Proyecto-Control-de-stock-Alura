package com.alura.jdbc.modelo;

public class Producto {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private Integer categoriaId;
	
	// Constructor para crear un producto sin ID
	public Producto(String nombre, String descripcion, Integer cantidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	// Constructor para crear un producto con ID
	public Producto(int id, String nombre, String descripcion, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	// Constructor para crear un producto con ID y sin descripción
	public Producto(int id, String nombre, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	// Método para obtener el nombre del producto
	public String getNombre() {
		return nombre;
	}

	// Método para obtener la descripción del producto
	public String getDescripcion() {
		return descripcion;
	}

	// Método para obtener la cantidad del producto
	public Integer getCantidad() {
		return cantidad;
	}
	
	// Método para obtener el ID del producto
	public Integer getId() {
		return this.id;
	}

	// Método para establecer el ID del producto
	public void setId(int id) {
		this.id = id;		
	}
	
	// Método para obtener el ID de la categoría a la que pertenece el producto
	public int getCategoriaId() {
		return this.categoriaId;
	}
	
	// Método para establecer el ID de la categoría a la que pertenece el producto
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
		
	// Sobrescritura del método toString para representar el producto con sus atributos
	@Override
	public String toString() {
		return String.format(
				"{id: %s, nombre: %s, descripcion: %s, cantidad: %d}", 
				this.id,
				this.nombre,
				this.descripcion,
				this.cantidad);	
	}
}
