package model

class Director(
    name: String, surname: String,
    dni: String, email: String,
    var nPeople: Int
) : Person(name, surname, dni, email) {
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPeople = ${nPeople}")
    }
}