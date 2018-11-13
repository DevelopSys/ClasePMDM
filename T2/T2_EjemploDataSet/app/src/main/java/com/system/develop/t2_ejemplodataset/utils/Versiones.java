package com.system.develop.t2_ejemplodataset.utils;

import com.system.develop.t2_ejemplodataset.R;

import java.io.Serializable;

public class Versiones implements Serializable {

    String nombre, desc;
    int api;

    public Versiones(String nombre, String desc, int api) {
        this.nombre = nombre;
        this.desc = desc;
        this.api = api;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public int getApi() {
        return api;
    }
}
