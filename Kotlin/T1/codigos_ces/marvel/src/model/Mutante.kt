package model

class Mutante(
    id: Int? = null,
    nombre: String? = null,
    nivel: Int? = null,
    var descripcion: String? = null,
    var arma: Biologica? = null
) : Heroe(id, nombre, nivel) {


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Descripciom: $descripcion")
        println("Arma: ${arma?.mostrarDatos() ?: "No tiene arma asignada"} ")
    }

    override fun asociarArma(arma: Arma) {
        this.arma = arma as Biologica
    }


}