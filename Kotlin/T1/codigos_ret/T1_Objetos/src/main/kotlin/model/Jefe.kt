package model

import data.Constantes

class Jefe(
    dni: String,
    nombre: String,
    apellido: String,
    sueldo: Double,
    pass: String,
    correo: String,
    telefono: Int,
    var beneficio: Double,
    var responsabilidad: Int
) :
    Trabajador(dni, nombre, apellido, sueldo, pass, correo, telefono) {
    override fun calcularSueldoNetoMes() {
        val salarioNeto = (salario - (salario * Constantes.RETENCION)) / Constantes.MESES
        println("El salario del jefe es: $salarioNeto")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Beneficio: $beneficio")
        println("Responsabilidad: $responsabilidad")
    }
}