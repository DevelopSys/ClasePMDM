package com.borja.proyectoequipos.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    String nombre;
    int escudo;

    public Equipo(String nombre, int escudo) {
        this.nombre = nombre;
        this.escudo = escudo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEscudo() {
        return escudo;
    }
}
