package model

import kotlin.time.Duration.Companion.minutes

class Alumno(
    nombre: String,
    apellido: String,
    correo: String,
    telefono: Int,
    var curso: String,
    var nivel: Int,
    var sueldo: Double?
) :
    Usuario(nombre, apellido, correo, telefono) {

    init {
        this.nombre = nombre+"_alumno"
    }

    fun trabajarConSueldo(){
        var division:Double? = sueldo?.div(12.0)?:0.0
        var muliplicacion:Double = (sueldo?.times(12.0)?:0.0)/12
        // var salario = sueldo.minus()
    }
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Curso $curso")
        println("Nivel $nivel")
    }

    fun asistirClase(){
        println("Estoy asistiendo a una clase")
    }

    override fun obtenerInformacion() {
        println("La informacion del alumno es:")
        println("$curso")
    }

}