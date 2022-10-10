abstract class Persona (var id: Int, var nombre: String){

    open fun mostrarDatos(){
        println("ID $id")
        println("NOMBRE $nombre")
    }

}