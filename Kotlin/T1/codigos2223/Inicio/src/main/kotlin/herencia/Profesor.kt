package herencia

class Profesor(nombre: String, apellido: String, dni: String, edad: Int) : Persona(nombre, apellido, dni, edad), Gestor {

    var salario: Int = 1000;

    constructor(nombre: String, apellido: String,dni: String,edad: Int, salario: Int) :
            this(nombre, apellido, dni,edad) {
        this.salario = salario;
    }

    init {
        if (salario<=1000){
            println("Acabas de ser contratado con el salario base")
        } else {
            println("Acabas de ser contratado con el salario ${salario}")
        }
    }

    fun funcionProfesor(){

    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario: $salario")
    }

    override fun archivarDocumento(documento: String) {
        TODO("Not yet implemented")
    }

    override fun archivarFactura(documento: String) {
        TODO("Not yet implemented")
    }
}