package controller

import model.Accionista
import model.Persona
import model.Trabajador

class Empresa {

    var listaPersonas: ArrayList<Persona>
    var cuentaVotos: Double = 0.0;

    init {
        listaPersonas = ArrayList()
    }

    fun mostrarDatosTrabajadores() {
        listaPersonas.forEach { it.mostrarDatos() }
    }

    fun mostrarSueldos() {
        listaPersonas.forEach {
            if (it is Trabajador && it is Accionista) {
                it.calcularSueldoNetoMes()
            }
        }
    }

    fun buscarPersona(dni: String) {
        listaPersonas.find { it.dni == dni }?.mostrarDatos()
            ?: println("no se ha encontrado la persona")

    }

    fun comenzarVotacion() {
        listaPersonas.forEach {
            if (it is Accionista) {
                cuentaVotos += it.emitirVotacion((1..10).random())
            }
        }

        println("El resultado de la votacion es $cuentaVotos")
    }

    fun registrarVoto(accionista: Accionista) {
        cuentaVotos += accionista.emitirVotacion((1..10).random());
    }

    fun mostrarResultadoVotacion() {
        println("El resultado de la votacion es de $cuentaVotos")
    }

    fun calcularSueldosMes() {
        // listaPersonas.forEach { it.calcularSueldoNetoMes() }
        // sacar todos los trabajadores y calcular su sueldo mes
        // listaPersonas.forEach { (it.javaClass == Trabajador::javaClass ).calcularSueldoNetoMes() }
    }

    fun agregarTrabajador(usuario: Persona) {


        if (listaPersonas.find { item: Persona -> item.dni == usuario.dni } == null) {
            listaPersonas.add(usuario)
        } else {
            println("No se puede agregar")
        }
        // agregar un trabajador a la lista, siempre y cuando no exista
        // un trabajador con ese DNI ya agregado
    }

}