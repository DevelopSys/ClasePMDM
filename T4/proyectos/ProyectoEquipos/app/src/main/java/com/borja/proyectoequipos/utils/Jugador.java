package com.borja.proyectoequipos.utils;

import androidx.annotation.NonNull;

public class Jugador {

    String nombre, posicion;
    boolean estrella;

    public Jugador(String nombre, String posicion, boolean estrella) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.estrella = estrella;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public boolean isEstrella() {
        return estrella;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre();
    }
}
