package model

import data.Constantes

class Autonomo(nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var cuotaSS: Int, var contratado: Boolean) :
    Trabajador(nombre, apellido, dni, sueldo) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Couta SS: $cuotaSS")
        println("Contratado: $contratado")
    }

    override fun calcularSueldoNetoMes() {
        var salarioMes = (sueldo - (cuotaSS *Constantes.MESES))/Constantes.MESES
        println("El salario mes del autonomo es $salarioMes")
    }


}