package com.alura.jdbc;

import javax.swing.JFrame;

import com.alura.jdbc.view.ControlDeStockFrame;

public class ControlDeStockMain {

    public static void main(String[] args) {
        // Crear y mostrar la ventana principal de la aplicación
        ControlDeStockFrame productoCategoriaFrame = new ControlDeStockFrame();
        productoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

