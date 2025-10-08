package model

class Participanta(var id: Int, var nombre: String, var presupuesto: Int = 10000000, var plantilla: ArrayList<Jugador> = arrayListOf()) {

    var puntos = 0;

    fun mostrarDatos(){
        println("id = ${id}")
        println("nombre = ${nombre}")
        println("presupuesto = ${presupuesto}")
        if (!plantilla.isEmpty()){
            plantilla.forEach {
                it.mostrarDatos()
            }
        }
    }

    // TODO fichar jugador
    // TODO plantilla valida
}