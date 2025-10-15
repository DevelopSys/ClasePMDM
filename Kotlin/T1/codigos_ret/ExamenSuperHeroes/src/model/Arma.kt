package model

abstract class Arma(var id: Int, var nombre: String, var nivelPotencia: Int, var nivelDanio: Int) {

    open fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("nivelPetencia = ${nivelPotencia}")
        println("nivelDanio = ${nivelDanio}")

    }

}