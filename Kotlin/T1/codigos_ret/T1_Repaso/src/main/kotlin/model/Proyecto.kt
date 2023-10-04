package model

class Proyecto(var titulo: String, var desc: String, var profesor: Profesor, var contenido: String) {

    var lista: ArrayList<Alumno>

    init {
       lista = ArrayList()
    }

    fun addIntegrante(integrante: Alumno){
        lista.add(integrante)
    }

    fun mostrarDatos(){
        println("Titulo $titulo")
        println("Descripcion $desc")
        println("Contenido $contenido")
        println("Los datos del profesor son: ")
        profesor.mostrarDatos()
        println("Los datos de los integrantes son: ")
        lista.forEach { it.mostrarDatos() }

    }

}