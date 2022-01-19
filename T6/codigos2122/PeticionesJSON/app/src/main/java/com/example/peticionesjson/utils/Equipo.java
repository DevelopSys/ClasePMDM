package com.example.peticionesjson.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    private String nombre, estadio, imagen, id, detalle;

    public Equipo(String nombre, String estadio, String imagen, String id, String detalle) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.imagen = imagen;
        this.id = id;
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
