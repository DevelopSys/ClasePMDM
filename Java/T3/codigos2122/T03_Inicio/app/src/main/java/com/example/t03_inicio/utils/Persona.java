package com.example.t03_inicio.utils;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Persona implements Serializable {

    // var de clase
    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;

    public Persona(){

    }

    public Persona(String nombre, String apellido, int telefono, boolean experiencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isExperiencia() {
        return experiencia;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }

    /*
    * { nombre: "Borja", apellido: "Martin", telefono: 12345, experiencia: True }
    * */
}
