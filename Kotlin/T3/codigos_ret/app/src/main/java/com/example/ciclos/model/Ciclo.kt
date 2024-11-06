package com.example.ciclos.model

class Ciclo(
    var nombre: String?=null,
    var familia: String?=null,
    var siglas: String?=null,
    var listaAsignaturas: ArrayList<Asignatura>?=null
)
{

    override fun toString(): String {
        return siglas!!
    }
}