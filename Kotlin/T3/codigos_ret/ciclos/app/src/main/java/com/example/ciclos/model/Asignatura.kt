package com.example.ciclos.model

class Asignatura(
    var nombre: String? = null,
    var siglas: String? = null,
    var hora: Int? = null,
    var troncal: Boolean? = null
) {
    override fun toString(): String {
        return siglas!!
    }
}