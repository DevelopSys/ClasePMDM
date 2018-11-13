package com.example.develop.t1_02_arrancaractividaddatos.utils;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre, apellido;
    int telefono;

    public Persona(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }
}
