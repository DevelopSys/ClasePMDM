package model

abstract class Persona (var dni: String,var nombre: String, var apellido: String) {

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }

}