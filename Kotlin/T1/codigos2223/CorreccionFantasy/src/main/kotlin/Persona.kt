abstract class Persona (var id: Int, var nombre: String) {

    open fun mostrarDatos(){
        println("Id: $id")
        println("Nombre: $nombre")
    }

}