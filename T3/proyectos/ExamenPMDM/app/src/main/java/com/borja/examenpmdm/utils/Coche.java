package com.borja.examenpmdm.utils;

import java.io.Serializable;

public class Coche implements Serializable {

    String marca, modelo;
    int cv;
    int imagen;

    public Coche(String marca, String modelo, int cv, int imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
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
}
