package controller

import model.Alumno
import model.Profesor
import model.Usuario
import kotlin.reflect.typeOf

class Colegio() {

    var id: Int = 0;
    val listaUsuarios: ArrayList<Usuario> = ArrayList()

    // []
    // agregar un alumno
    fun agregarAlumno(alumno: Usuario) {
        id++;
        alumno.id = id;
        listaUsuarios.add(alumno)
        println("Alumno agregado correctamente")
    }

    fun desmatricular(id: Int) {
        val encontrado: Usuario? = listaUsuarios.find {
            it.id == id
        }
        encontrado?.desmatricular() ?: println("No se ha encontra el alumno")
        if (encontrado != null) {
            println("Desmatriculado alumno con nombre ${encontrado.nombre}")
        }
        /*if (encontrado!=null){
    encontrado!!.desmatricular()
} else {
    println("No se encuentra un alumno con el id aportado")
}*/
    }

    fun listarAlumno(opcion: Int) {
        if (!listaUsuarios.isEmpty()) {
            var opcionMatricula = false;
            if (opcion == 1) {
                opcionMatricula = true;
            } else if (opcion == 2) {
                opcionMatricula = false;
            }

            when (opcion) {
                1 -> {
                    listaUsuarios.forEach {
                        it.mostrarDatos()
                    }
                }

                2 -> {
                    // matriculados
                    listaUsuarios.filter { it.matriculado }.forEach { it.mostrarDatos() }
                }

                3 -> {
                    // desmatriculados
                    listaUsuarios.filter { !it.matriculado }.forEach { it.mostrarDatos() }
                }
            }
        } else {
            println("No hay alumnos en la lista")
        }
    }

    fun calificarAlumno(id: Int) {

        // listaAlumnos.find { it.id == id }?.calificacion= calificacionNota ?: println("No se encuentra el usuario")
        var encontrado: Usuario? = listaUsuarios.find { it.id == id }
        if (encontrado != null) {
            var calificacionNota: Double = 0.0;
            do {
                println("Indica la calificacion que quieres poner")
                calificacionNota = readln().toDouble()
            } while (calificacionNota < 0 || calificacionNota > 10)
            encontrado.calificacion = calificacionNota;
        } else {
            println("Alumno no encontrado")
        }
    }

    // Agregar un usuario al arraylist -> funcion
    // no pueden existir dos usuarios que tengan el mismo correo
    fun agregarComun(usuario: Usuario) {
        // no hay uno ya con el correo

        val usuarioBuesqueda = listaUsuarios.find { it.correo.equals(usuario.correo, false) }
        if (usuarioBuesqueda == null) {
            listaUsuarios.add(usuario)
            println("Usuario agregado correctamente")
        } else {
            println("No se puede agregar porque existe uno con ese correo ${usuarioBuesqueda.nombre}")
        }
    }

    // Liste los alumnos que esten matriculados (true) en un
    // ciclo pasado por parametros
    fun listarCiclo(ciclo: String) {
        listaUsuarios.filter {
            if (it::class.java.simpleName.equals("Alumno")) {
                if ((it as Alumno).curso.equals(ciclo, false) && it.matriculado) {
                    return@filter true;
                }
            }
            return@filter false
        }.forEach {
            it.mostrarDatos()
        }
    }

    // Mostar el sueldo medio de los profesores
    fun sueldoMedio(): Double{
        val listaProfes = listaUsuarios.filter {
            if (it::class.java.simpleName.equals("Profesor")) {
                return@filter true
            }
            return@filter false
        }
        var sueldoMedio: Double = 0.0;
        listaProfes.forEach {
            sueldoMedio+=(it as Profesor).sueldo
        }

        return sueldoMedio/listaProfes.size
    }



    // true, ASIR -> matriculado en ASIR
    // false, ASIR -> no matriculado en ASIR

}