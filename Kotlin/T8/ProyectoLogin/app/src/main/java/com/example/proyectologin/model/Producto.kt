package com.example.proyectologin.model

data class Producto (var nombre: String?=null, var valor: Int?=null) {

    var descripcion: String?=null
    var usuarios: ArrayList<String> = ArrayList()

    constructor(nombre: String?=null,valor: Int?=null, descripcion: String?=null) : this(nombre,valor) {
        this.descripcion = descripcion;
    }

}