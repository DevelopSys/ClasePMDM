package controller

import model.Alumno
import model.Profesor
import model.Proyecto

class Ciclo {

    lateinit var listaAlumno: ArrayList<Alumno>;
    lateinit var listaProfesores: ArrayList<Profesor>
    lateinit var listaProyectos: ArrayList<Proyecto>

    init {
        listaAlumno = ArrayList()
        listaProfesores = ArrayList()
        listaProyectos = ArrayList()
    }

    fun addAlumno(alumno: Alumno): Unit {
        // existe el alumno
        if (getAlumno(alumno.dni) != null) {
            listaAlumno.add(alumno)
        } else {
            println("No se puede agregar, ya existe un alumno con ese DNI")
        }
    }

    fun addProfesor(profesor: Profesor) {
        if (getProfesor(profesor.dni) != null) {
            listaProfesores.add(profesor)
        } else {
            println("No se puede agregar, ya existe un profesor con ese DNI")
        }
    }

    fun addProyecto(proyecto: Proyecto){
        listaProyectos.add(proyecto)
    }

    fun listarProyectos() {
        listaProyectos.forEach { it.mostrarDatos() }
    }

    fun getAlumno(dni: String): Alumno? {
        return listaAlumno.find { it.dni == dni }
    }

    fun getProfesor(dni: String): Profesor? {
        return listaProfesores.find { it.dni == dni }
    }

}