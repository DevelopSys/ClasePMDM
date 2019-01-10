package com.system.develop.t4_ejemploexamenrec.utils;

import java.io.Serializable;

public class Peliculas implements Serializable {

    String titulo, url;

    public Peliculas(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }
}
