package com.system.develop.t2_cardview.utils;

import java.io.Serializable;

public class Juego implements Serializable {

    String nombre, desc;
    int imagen;

    public Juego(String nombre, String desc, int imagen) {
        this.nombre = nombre;
        this.desc = desc;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public int getImagen() {
        return imagen;
    }
}
