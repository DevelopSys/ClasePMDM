package herencia

class Alumno(nombre: String, apellido: String, dni: String, edad: Int)
    : Persona(nombre, apellido, dni, edad) {

    var matricula: String? = null;

    constructor(nombre: String, apellido: String, dni: String,
                edad: Int, matricula: String) : this(
        nombre,
        apellido,
        dni,
        edad) {
        this.matricula = matricula;
    }

    init {
        if (this.edad > 18) println("Procedemos a tu matricula")
        else println("No eres mayor de edad, por lo tanto no puedes darte de alta")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Matricula: $matricula")
    }

    // HACER LA HERENCIA DE LOS PROFESORES Y PONER QUE TIENEN UN SUELDO MINIMO DE 1000€

}