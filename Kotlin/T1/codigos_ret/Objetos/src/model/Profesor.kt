package model

class Profesor(
    nombre: String,
    apellido: String,
    correo: String,
    telefono: Int,
    var sueldo: Int,
    var autonomo: Boolean
) : Usuario(nombre, apellido, correo, telefono) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Sueldo total $sueldo")
        println("Autonomo $autonomo")
    }

    fun impartirClase(){
        println("Voy a impartir una clase como docente")
    }

    override fun obtenerInformacion() {
        println("La informacion del alumno es:")
        if (autonomo){
            println("El sueldo es ${sueldo-(120*12)}")
        } else{
            println("El sueldo es ${sueldo}")
        }
    }
}