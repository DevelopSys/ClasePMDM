package com.example.proyectomodelos.utils;

public class Modelo {

    private String modelo;
    private int cv, imagen;
    private Marca marca; // imagen, marca

    public Modelo(String modelo, int cv, int imagen, Marca marca) {
        this.modelo = modelo;
        this.cv = cv;
        this.imagen = imagen;
        this.marca = marca;
    }

    public Modelo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
