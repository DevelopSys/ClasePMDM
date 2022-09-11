package com.borja.t3_elementos.utils;

public class Coche {

    private String modelo,marca;
    private int cv, km, imagen;

    public Coche(String modelo, String marca, int cv, int km) {
        this.modelo = modelo;
        this.marca = marca;
        this.cv = cv;
        this.km = km;
    }

    public Coche(String modelo, String marca, int cv, int km, int imagen) {
        this.modelo = modelo;
        this.marca = marca;
        this.cv = cv;
        this.km = km;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return getModelo();
    }
}
