package com.example.json.utils;

import java.io.Serializable;

public final class Equipo implements Serializable {

    private String id, nombre, anio, estadio, escudo;

    public Equipo(String id, String nombre, String anio, String estadio, String escudo) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.estadio = estadio;
        this.escudo = escudo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
}
