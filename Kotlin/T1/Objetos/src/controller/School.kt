package controller

import model.Director
import model.Person
import model.Student
import model.Teacher
import kotlin.system.exitProcess

class School() {

    lateinit var people: ArrayList<Person>
    lateinit var teachers: ArrayList<Any>
    lateinit var students: ArrayList<Student>

    var director: Director? = null

    init {
        people = arrayListOf()
        // estas listas no las voy a utilizar
        teachers = arrayListOf()
        students = arrayListOf()
    }

    // contratar un director
    fun createDirector(director: Director) {
        if (this.director != null) {
            println("Ya tienes un director, le quieres despedir")
            val despedir = readln()
            // S == s S.equalIgnoreCase("s")
            // S == s S.equal("s")
            if (despedir.equals("s", true)) {
                println("director despedido")
                this.director = director
                return
            } else {
                println("Nos quedamos con el director")
                return
            }
        } else {
            this.director = director
            return
        }
    }

    fun addTeacher(teacher: Teacher) {
        // existe un dni igual al que intento agregar (alumno/profesor o de director)
        val peopleExist: Person? = people.find { it.dni.equals(teacher.dni, true) }
        val directorExist: Boolean = director != null
                && director?.dni.equals(teacher.dni, true)

        if (peopleExist == null && !directorExist) {
            people.add(teacher)
        } else {
            println("La persona que intentas agregar ya esta dada de alta con ese DNI")
        }

        /*
        if (peopleExist(teacher.dni)) {

        } else {

        }*/

    }

    private fun peopleExist(dni: String): Boolean {
        val peopleExist: Person? = people.find { it.dni.equals(dni, true) }
        val directorExist: Boolean = director != null
                && director?.dni.equals(dni, true)

        return peopleExist != null && directorExist
    }

    fun listStudent(): Unit {
        people.forEach {
            if (it is Student) {
                it.mostrarDatos()
            }
        }
    }

    fun listTeacger(): Unit {
        people.forEach {
            if (it is Teacher) {
                it.mostrarDatos()
            }
        }
    }


    // realizar los metodos necesarios para matricular alumnos, contratar profesores.
    // no puede haber alumnos, profesores, director con el mismo correo, dni,
    // no puede haber alumnos con el mismo nia (autocopmletado)
    // si usamos el array de people, cuando se contrata profesor, se tiene que ver que
    // el objeto pasado es de tipo profesor
    // realizar los metodos necesarios para listar
    // alumnos
    // profesores

    // los alumnos tienen ademas de los datos que tienen ahora
        // tienen notas: conjunto de numeros (1-10)

    // hacer el metodo necesario para poder calificar a un alumno
        // el metodo
            // obtiene por parametros el dni de un profe
            // obtiene por parametros el dni de un alumno
            // obtiene por parametros la calificacion
        // el metodo necesita comprobar errores
            // me dices un dni de profesor que no esta
            // me dices un dni de profesor que no es de un profesor
            // me dices un dni de alumno que no es de un alumno
            // me dices un dni de alumno que no esta
    // hacer un metodo que calcule la media actual de un alumno
        // el metodo
            // obtiene como parametro u dni (comprobar errores)
            // sacar por consola la media
                // en caso de no tener notas -> 0.0





}