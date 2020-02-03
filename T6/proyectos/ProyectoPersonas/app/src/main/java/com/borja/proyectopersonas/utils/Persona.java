package com.borja.proyectopersonas.utils;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre, apellido;
    int imagen;

    public Persona(String nombre, String apellido, int imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getImagen() {
        return imagen;
    }
}
