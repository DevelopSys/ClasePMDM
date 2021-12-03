package com.example.listas.utils;

public class Modelo {

    private String nombre;
    private String marca;
    private int imagen, potencia;

    public Modelo(String nombre, String marca, int imagen, int potencia) {
        this.nombre = nombre;
        this.marca = marca;
        this.imagen = imagen;
        this.potencia = potencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}
