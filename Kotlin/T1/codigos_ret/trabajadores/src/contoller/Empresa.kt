package contoller

import model.Jefe
import model.Trabajador

class Empresa {

    val listaTrabajadores: ArrayList<Trabajador>

    init {
        listaTrabajadores = ArrayList()
    }

    // contratar
    fun contratar(trabajador: Trabajador) {
        val duplicado = listaTrabajadores.find { it.dni.equals(trabajador.dni, true) }
        if (duplicado == null) {
            listaTrabajadores.add(trabajador)
        } else {
            println("no puedo contratarte porque ya tengo alguien con este DNI")
        }
    }

    // despedir
    fun despedir(dniJefe: String, dniTrabajador: String){
        val jefe: Trabajador? = listaTrabajadores.find {
            if (it::class.java.simpleName.equals("Jefe")){
                return@find true
            } else {
                return@find false
            }
        }

        (jefe as Jefe).despedir(dniTrabajador,listaTrabajadores)

    }
    // listar
    fun listar(tipo: Int) {
        // 0->todos
        // 1->Asalariados
        // 2->Autonomos
        listaTrabajadores.forEach {
            when (tipo) {
                0 -> {
                    it.mostrarDatos()
                }
                1 -> {
                    if (it::class.java.simpleName.equals("Asalariado")) {
                        it.mostrarDatos()
                    }
                }
                2 -> {
                    if (it::class.java.simpleName.equals("Autonomo")) {
                        it.mostrarDatos()
                    }
                }
            }
        }
    }
    // buscar
    fun buscar(dni: String){
        val encontrado = listaTrabajadores.find { it.dni == dni }
        if (encontrado !=null){
            encontrado.mostrarDatos()
        } else {
            println("No encuentro el usuario")
        }
    }
}