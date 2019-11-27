package com.borja.t04_spinnerperso.utils;

public class Marca {

    private String nombre;
    private int logo;

    public Marca(String nombre, int logo) {
        this.nombre = nombre;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
