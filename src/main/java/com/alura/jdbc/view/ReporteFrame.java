package com.alura.jdbc.view;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.alura.jdbc.controller.CategoriaController;

public class ReporteFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // Componentes de la interfaz
    private JTable tablaReporte;
    private DefaultTableModel modelo;

    private CategoriaController categoriaController;

    public ReporteFrame(ControlDeStockFrame controlDeStockFrame) {
        super("Reporte de produtos del stock");

        // Inicializar el controlador de categorías
        this.categoriaController = new CategoriaController();

        Container container = getContentPane();
        setLayout(null);

        // Configurar la tabla de reporte	
        tablaReporte = new JTable();
        tablaReporte.setBounds(0, 0, 600, 400);
        container.add(tablaReporte);

     // Configurar modelo de la tabla
        modelo = (DefaultTableModel) tablaReporte.getModel();
        modelo.addColumn(""); // Columna en blanco
        modelo.addColumn("Categoría"); // Columna para nombres de categorías
        modelo.addColumn("Producto"); // Columna para nombres de productos
        modelo.addColumn("Cantidad"); // Columna para cantidades de productos

        // Cargar datos en la tabla de reporte
        cargaReporte();

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(controlDeStockFrame);
    }

    // Método para cargar el reporte en la tabla
    private void cargaReporte() {
        var contenido = categoriaController.cargaReporte();
        
        // Iterar sobre las categorías y sus productos
        contenido.forEach(categoria -> {
            modelo.addRow(new Object[] { categoria });
            
            var productos = categoria.getProductos();
            
            // Iterar sobre los productos de la categoría
            productos.forEach(producto -> modelo.addRow(
                new Object [] {
                    "",
                    producto.getNombre(),
                    producto.getCantidad()
                }
            ));             
        });
    }

}

