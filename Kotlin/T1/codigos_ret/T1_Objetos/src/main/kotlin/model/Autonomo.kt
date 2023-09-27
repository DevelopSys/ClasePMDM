package model

import data.Constantes

class Autonomo(
    dni: String,
    nombre: String,
    apellido: String,
    sueldo: Double,
    pass: String,
    correo: String,
    telefono: Int,
    var coutaSS: Int
) :
    Trabajador(dni,nombre, apellido, sueldo, pass, correo, telefono) {
    override fun calcularSueldoNetoMes() {
        var salarioMes = (salario - (coutaSS * Constantes.MESES)).toDouble()/Constantes.MESES
        println("El salario del autonomo es: $salarioMes")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Coute SS: $coutaSS")

    }
}