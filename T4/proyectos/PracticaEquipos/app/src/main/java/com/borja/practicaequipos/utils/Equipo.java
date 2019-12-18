package com.borja.practicaequipos.utils;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Equipo implements Serializable {

    String nombre, estadio;
    Jugador[]plantilla;
    int escudo;

    public Equipo(String nombre, String estadio, int escudo) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.plantilla = plantilla;
        this.escudo = escudo;
    }

    public Equipo(String nombre, String estadio, Jugador[] plantilla) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.plantilla = plantilla;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public Jugador[] getPlantilla() {
        return plantilla;
    }

    public int getEscudo() {
        return escudo;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre();
    }
}
