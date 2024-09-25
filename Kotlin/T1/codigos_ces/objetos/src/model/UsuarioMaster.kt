package model

class UsuarioMaster(
    nombre1: String? = null,
    apellido1: String? = null,
    correo1: String,
    var curso: Int,
    var especialidad: String
) : Usuario(nombre1, apellido1, correo1) {

    override fun mostrarDatos(){
        super.mostrarDatos()
        println("Curso: $curso")
        println("Especialidad: $especialidad")
    }

    override fun imprimirExpediente() {
        println("Imprimiento expediente master")
        println("******MASTER ${especialidad}********")
        this.mostrarDatos()
    }


}