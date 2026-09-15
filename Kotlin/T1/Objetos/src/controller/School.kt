package controller

import model.Director
import model.Person
import model.Student
import kotlin.system.exitProcess

class School() {

    lateinit var people: ArrayList<Person>
    lateinit var teachers: ArrayList<Any>
    lateinit var students: ArrayList<Student>

    var director: Director? = null

    init {
        people = arrayListOf()
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
        } else{
            this.director = director
            return
        }
    }

    // realizar los metodos necesarios para matricular alumnos, contratar profesores.
        // no puede haber alumnos, profesores, director con el mismo correo, dni,
        // no puede haver alumnos con el mismo nia (autocopmletado)
        // si usamos el array de people, cuando se contrata profesor, se tiene que ver que
        // el objeto pasado es de tipo profesor
    // realizar los metodos necesarios para listar
        // alumnos
        // profesores

}