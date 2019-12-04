package com.borja.t04_vistarrecicladas.utils;

public class Persona {

    String nombre, apellido;
    int telefono;
    int sexo;

    public Persona(String nombre, String apellido, int telefono, int sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.sexo = sexo;
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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
