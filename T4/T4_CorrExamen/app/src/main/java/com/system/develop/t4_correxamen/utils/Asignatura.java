package com.system.develop.t4_correxamen.utils;

public class Asignatura {

    String nombre;
    int imagen;

    public Asignatura(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}
