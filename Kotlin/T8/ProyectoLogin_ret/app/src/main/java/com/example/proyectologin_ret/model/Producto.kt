package com.example.proyectologin_ret.model

data class Producto(var nombre: String?=null, var valor: Int?=null): java.io.Serializable{

    var cv: Int? =null
    constructor(nombre: String?=null,valor: Int?=null, cv: Int?=null) : this(nombre,valor) {
        this.cv = cv;
    }
}