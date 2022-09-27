package model

open abstract class Persona (protected var nombre: String,
                             protected  var apellido: String,
                             protected  var dni: String) {

    open fun mostrarDatos(){
        println("Nombre $nombre")
        println("Apellido $apellido")
        println("DNI $dni")
    }

}