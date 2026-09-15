package model

class Student(
    name: String, surname: String,
    dni: String, email: String,
    var nia: Int, var mat: Int
) : Person(name, surname, dni, email) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nia = ${nia}")
        println("mat = ${mat}")
    }
}