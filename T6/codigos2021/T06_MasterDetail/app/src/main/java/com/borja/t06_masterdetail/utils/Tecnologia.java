package com.borja.t06_masterdetail.utils;

import java.io.Serializable;

public class Tecnologia implements Serializable {

    private String nombre, caracteristicas;
    private int logo;

    public Tecnologia(String nombre, String caracteristicas, int logo) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Tecnologia{" +
                "nombre='" + nombre + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", logo=" + logo +
                '}';
    }
}
