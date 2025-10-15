package model

abstract class SuperHeroe(var id: Int, var nombre: String, var nivel: Int){

    var arma: Arma?=null
    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivel = ${nivel}")
    }
}