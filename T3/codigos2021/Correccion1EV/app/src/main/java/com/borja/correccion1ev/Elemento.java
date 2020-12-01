package com.borja.correccion1ev;

public class Elemento {

    private String nombre, detalle, categoria;
    private int imagen;

    public Elemento(String nombre, String detalle, int imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.imagen = imagen;
    }

    public Elemento(String nombre, String detalle, int imagen, String categoria) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getImagen() {
        return imagen;
    }
}
