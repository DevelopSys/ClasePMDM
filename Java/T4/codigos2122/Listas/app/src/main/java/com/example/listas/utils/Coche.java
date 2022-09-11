package com.example.listas.utils;

public class Coche {

    private String modelo, marca;
    private int imagen, cv;

    public Coche(String modelo, String marca, int imagen, int cv) {
        this.modelo = modelo;
        this.marca = marca;
        this.imagen = imagen;
        this.cv = cv;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }
}
