package com.borja.examenpmdm.utils;

public class Marca {

    String marca;
    int logo;

    public Marca(String marca, int logo) {
        this.marca = marca;
        this.logo = logo;
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
