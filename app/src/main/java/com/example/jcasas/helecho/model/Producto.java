package com.example.jcasas.helecho.model;

/**
 * Created by jcasas on 5/6/17.
 */

public class Producto {

    private String id;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;
    private String categoria;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public Producto(String id,
                    String nombre,
                    int cantidad,
                    double precio,
                    String descripcion,
                    String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
}
