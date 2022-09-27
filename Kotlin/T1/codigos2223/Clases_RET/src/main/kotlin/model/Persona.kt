package model

open abstract class Persona (var nombre: String, var apellido: String, var edad: Int){

    // variables nombre, apellido, edad
    // todas variables en const primario, tienen get set implicitos

    protected var peso: Double? = null;
    protected lateinit var dni: String

    constructor(nombre: String, apellido: String, edad: Int, peso: Double)
            : this(nombre,apellido,edad) {
        this.peso = peso;
    }

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Edad: $edad")
    }

    fun setDNI(dni: String){
        this.dni = dni;
    }

    fun getDNI(): String{
        return this.dni;
    }



}