package model

class Empresa() {

    var trabajadores: ArrayList<Persona>?;

    init {
        trabajadores = ArrayList();
    }

    fun agregarTrabajador(persona: Persona) {
        trabajadores?.add(persona)
    }

    fun listarTrabajadores(filtro: String) {

        trabajadores?.forEach { persona ->
            when (filtro) {
                "Jefe" -> {
                    if (persona is Jefe) {
                        persona.mostrarDatos()
                    }
                }
                "Asalariado" -> {
                    if (persona::class.simpleName?.toLowerCase() == filtro.toLowerCase()){
                        //(persona as Asalariado).numeroPagas
                        persona.mostrarDatos()
                    }

                }
                else -> {

                    persona.mostrarDatos()
                }
            }
            //print(it.mostrarDatos())
        }
    }
}