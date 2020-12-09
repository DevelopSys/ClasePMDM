package com.borja.t04_dialogos.utils;

public class Equipo {

    private String nombre, liga;
    private int imagen;

    public Equipo(String nombre, String liga, int imagen) {
        this.nombre = nombre;
        this.liga = liga;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
