package model

abstract class Persona(var nombre: String, var apellido: String, var dni: String) {

    // nombre, apellido, dni (obligatorio)
    // opcional telefono y correoE
    var telefono: Int? = null;
    var correoE: String? = null;



    constructor(nombre: String, apellido: String, dni: String, telefono: Int, correoE: String) : this(
        nombre,
        apellido,
        dni
    ) {
        this.telefono = telefono
        this.correoE = correoE
    }

    open fun mostrarDatos(){
        println("El nombre : $nombre")
        println("El apellido : $apellido")
        println("El dni : $dni")
        println("El telefono : ${telefono ?: "no se ha especificado"}")
        println("El correc : ${correoE ?: "no se ha especidicado"}")
    }
}