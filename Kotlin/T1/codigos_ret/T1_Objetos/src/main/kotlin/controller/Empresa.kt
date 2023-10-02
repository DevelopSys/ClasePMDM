package controller

import model.Trabajador

class Empresa {

    var listaTrabajadores: ArrayList<Trabajador>

    init {
        listaTrabajadores = ArrayList()
    }

    // agregarTrabajor()

    fun calcularSueldosMes() {
        listaTrabajadores.forEach { it.calcularSueldoNetoMes() }
    }

    fun agregarTrabajador(usuario: Trabajador) {

        // [1,2,3,4]
        // 6
        // se puede -> si no está
        // obtengo el usuario que cumple la condicion
        if (listaTrabajadores.find { item: Trabajador -> item.dni == usuario.dni } == null) {
            listaTrabajadores.add(usuario)
        } else {
            println("No se puede agregar")
        }
        // agregar un trabajador a la lista, siempre y cuando no exista
        // un trabajador con ese DNI ya agregado
    }


}