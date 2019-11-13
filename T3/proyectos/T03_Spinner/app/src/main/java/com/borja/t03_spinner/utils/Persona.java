package com.borja.t03_spinner.utils;

import androidx.annotation.NonNull;

public class Persona {

    String nombre, apellido;
    int edad;
    boolean disponiblidad;

    public Persona(String nombre, String apellido, int edad, boolean disponiblidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.disponiblidad = disponiblidad;
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

    public boolean isDisponiblidad() {
        return disponiblidad;
    }

    public void setDisponiblidad(boolean disponiblidad) {
        this.disponiblidad = disponiblidad;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre();
    }
}
