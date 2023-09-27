package controller

import model.Trabajador

class Empresa() {

    var listaTrabajadores: ArrayList<Trabajador>;


    init {
        listaTrabajadores = ArrayList()
    }

    fun pedirDatos() {
        var numero = readln().toUInt()
    }
    // agregar trabajador - AS AU JF -> no puede haber dos trabajadores con el mismo DNI
    // listar todos
    // listar detalle - dni
    // eliminar - despedir

    fun buscarTrabajador(trabajadorP: Trabajador): Boolean? {

        if (listaTrabajadores.find { it.dni == trabajadorP.dni } != null){
            return true
        }
        return false
            /*if (listaTrabajadores.filter { it.dni == trabajadorP.dni }.size > 0)
            if (listaTrabajadores.forEach() { it.dni == trabajadorP.dni } > 0)

            // return listaTrabajadores.find { it.dni == trabajadorP.dni }
                return listaTrabajadores.filter { it.dni == trabajadorP.dni }[0]*/
    }
}