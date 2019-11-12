package com.borja.t3_spinnerr.utils;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {

    String nombre, apellido;
    int edad;
    boolean disponibilidad;


    public Persona(String nombre, String apellido, int edad, boolean disponibilidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.disponibilidad = disponibilidad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre();
    }
}
