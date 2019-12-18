package com.borja.practicaequipos.utils;

import java.io.Serializable;

public class Liga implements Serializable {

    String nombre, pais;
    Equipo[] equipos;
    int logo;

    public Liga(String nombre, String pais, int logo) {
        this.nombre = nombre;
        this.pais = pais;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public int getLogo() {
        return logo;
    }
}
