package com.develop.usuariosfirebase.utils;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String uid, nombre, tipo;
    private int telefono;

    public Usuario() {
    }

    public Usuario(String uid, String nombre, String tipo, int telefono) {
        this.uid = uid;
        this.nombre = nombre;
        this.tipo = tipo;
        this.telefono = telefono;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "uid='" + uid + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
