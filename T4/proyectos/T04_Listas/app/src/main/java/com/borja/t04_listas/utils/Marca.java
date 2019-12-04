package com.borja.t04_listas.utils;

public class Marca {

    String marca;
    int logo;
    long id;

    public long getId() {
        return id;
    }

    public Marca(String marca, int logo, long id) {
        this.marca = marca;
        this.logo = logo;
        this.id = id;
    }

    public Marca(String marca, int logo) {
        this.marca = marca;
        this.logo = logo;
    }

    public Marca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
