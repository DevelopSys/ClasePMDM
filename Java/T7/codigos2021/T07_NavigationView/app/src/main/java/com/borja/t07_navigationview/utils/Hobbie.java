package com.borja.t07_navigationview.utils;

public class Hobbie {
    private String nombre, detalle;
    private int imagen;

    public Hobbie(String nombre, String detalle, int imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.imagen = imagen;
    }

    // Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


}
