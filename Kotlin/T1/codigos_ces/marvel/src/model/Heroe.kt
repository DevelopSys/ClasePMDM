package model

abstract class Heroe(var id: Int? = null, var nombre: String? = null, var nivel: Int? = null) {

    open fun mostrarDatos() {
        println("ID $id")
        println("Nombre $nombre")
        println("Nivel $nivel")
    }

    abstract fun asociarArma(arma: Arma);
}