package model

import data.Constantes

class Jefe(nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var beneficio: Int, var accion: Int) :
    Trabajador(nombre, apellido, dni, sueldo) {
    override fun calcularSueldoNetoMes() {
        var salarioMes = sueldo / 12;
        println("El salario mes del jefe es $salarioMes")
    }

    override fun mostrarDatos() {

        super.mostrarDatos()
        println("Acciones $accion")
        println("Beneficios $beneficio")
    }
}