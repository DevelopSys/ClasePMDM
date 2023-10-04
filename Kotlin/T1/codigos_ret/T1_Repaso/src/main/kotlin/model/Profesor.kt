package model

class Profesor (var nombre: String, var apellido: String, var dni: String) {

    var correo: String? = null;

    constructor(nombre: String, apellido: String, dni: String, correo: String) :
            this(nombre,apellido,dni) {
        this.correo = correo;
    }

    fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }
}