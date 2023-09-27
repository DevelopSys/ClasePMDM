package model

import data.Constantes

class Asalariado(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Int = 10000,
    var numeroPagas: Int,
    var contratado: Boolean = false
) :
    Trabajador(nombre, apellido, dni, sueldo) {
    override fun calcularSueldoNetoMes() {
        var sueldoMes = (sueldo - sueldo*Constantes.RETENCIONES)/numeroPagas
        println("El salario mensual del asalariado es $sueldoMes")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Nº pagas $numeroPagas")
        println("Contratado $contratado")
    }
}