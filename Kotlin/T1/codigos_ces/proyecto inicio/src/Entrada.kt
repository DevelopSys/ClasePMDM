fun main() {

    // variables que pueden cambiar -> mutables
    var nombre: String = "Borja"
    var apellido: String? = null
    var edad: Int = 40
    // variables que no pueden cambiar -> no mutables
    val experiancia: Boolean = false


    println(apellido!!.length ?:"no hay apellido")


}
