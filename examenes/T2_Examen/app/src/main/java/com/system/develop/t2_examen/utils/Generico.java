package com.system.develop.t2_examen.utils;

public class Generico {

    String nombre, detalle;
    int imagen;

    public Generico(String nombre, String detalle, int imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public String getDetalle() {
        return detalle;
    }
}
