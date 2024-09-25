package model

class Alumno(
    nombre: String,
    apellido: String,
    correo: String,
    telefono: Int,
    var curso: String,
    var nivel: Int
) :
    Usuario(nombre, apellido, correo, telefono) {

    init {
        this.nombre = nombre+"_alumno"
    }
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Curso $curso")
        println("Nivel $nivel")
    }

}