package herencia

open class Persona (var nombre: String, var apellido: String, val dni: String) {

    // nombre, apellido, dni
    var edad: Int=0;

    constructor(nombre: String, apellido: String, dni: String, edad: Int):
            this(nombre,apellido,dni){
        this.edad = edad;
    }

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
        println("Edad: $edad")
    }

}