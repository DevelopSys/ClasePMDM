package model

final class Jefe(nombre: String, apellido: String, dni: String) : Persona(nombre, apellido, dni) {

    var beneficio: Double = 0.0;
    var acciones: Int = 0;

    override fun mostrarDatos() {
        super.mostrarDatos()
        if (this.beneficio != 0.0)
            println("Beneficio: $beneficio")
        else println("Sin beneficios")
        if (this.acciones != 0)
            println("Beneficio: $beneficio")
        else println("Sin acciones asignadas ")

    }

}