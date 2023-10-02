package model

import data.Constantes

class Asalariado(
    dni: String,
    nombre: String,
    apellido: String,
    sueldo: Double,
    pass: String,
    correo: String,
    telefono: Int,
    var numeroPagas: Int=12
) :
    Trabajador(dni,nombre, apellido, sueldo, pass, correo, telefono) {
    override fun calcularSueldoNetoMes() {
        val salarioNeto = (salario - (salario * Constantes.RETENCION)) / numeroPagas
        println("El salario neto mensual es de $salarioNeto")
    }

    fun metodoAsalariado(){

    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Nº pagas $numeroPagas")
    }
}