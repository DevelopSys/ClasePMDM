package com.borja.practicaequipos.utils;

import androidx.annotation.NonNull;

public class Jugador {

    int id;
    String nombre, apellido, posicion;
    boolean estrella;

    public Jugador( String nombre, String apellido, String posicion, boolean estrella) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.estrella = estrella;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
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
        return getNombre() +" "+getApellido();
    }
}
