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
    Trabajador(dni, nombre, apellido, sueldo, pass, correo, telefono), Accionista {
    override fun calcularSueldoNetoMes() {
        val salarioNeto = (salario - (salario * Constantes.RETENCION)) / Constantes.MESES
        println("El salario del jefe es: $salarioNeto")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Beneficio: $beneficio")
        println("Responsabilidad: $responsabilidad")
    }

    override fun emitirVotacion(voto: Int): Double {
        // emite un voto y su valor es el 25% de lo que dice
        println("Registrando voto del jefe por valor de $voto")
        return voto * 0.25
    }
}