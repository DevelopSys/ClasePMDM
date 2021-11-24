package com.example.proyectomodelos.utils;

public class Marca {

    private String marca;
    private int imagen;

    public Marca(){}

    public Marca(String marca) {
        this.marca = marca;
    }

    public Marca(String marca, int imagen) {
        this.marca = marca;
        this.imagen = imagen;
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
}
