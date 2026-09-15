package model


class Teacher(
    name: String, surname: String,
    dni: String, email: String,
    var salary: Int, var hour: Int
) : Person(name, surname, dni, email) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("salary = ${salary}")
        println("hour = ${hour}")
    }
}