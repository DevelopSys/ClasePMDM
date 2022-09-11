package com.example.recycler.utils;

public class Modelo {

    private int imagen;
    private String marca, modelo;
    private int potencia;

    public Modelo(int imagen, String marca, String modelo, int potencia) {
        this.imagen = imagen;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}
