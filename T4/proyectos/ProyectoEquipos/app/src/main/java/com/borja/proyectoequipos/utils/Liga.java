package com.borja.proyectoequipos.utils;

public class Liga {

    String nombre;
    int logo;

    public Liga(String nombre, int logo) {
        this.nombre = nombre;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLogo() {
        return logo;
    }
}
