package model

open class Person(var name: String, var surname: String, val dni: String) {

    var email: String? = null

    constructor(nameS: String, surnameS: String, dniS: String, email: String)
            : this(nameS, surnameS, dniS) {
       this.email = email
    }

    open fun mostrarDatos(): Unit {
        println("name = ${name}")
        println("surname = ${surname}")
        println("dni = ${dni}")
        println("email = ${email ?: "no se ha definido email"}")
    }
}