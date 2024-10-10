package model

class Humanos(
    id: Int? = null,
    nombre: String? = null,
    nivel: Int? = null,
    var resistencia: Int? = null,
    var arma: Tradicional? = null
) : Heroe(id, nombre, nivel) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Resistencia: $resistencia")
        println("Arma: ${arma?.mostrarDatos() ?: "No tiene arma asignada"} ")
    }

    override fun asociarArma(arma: Arma) {
        this.arma = arma as Tradicional ;
    }

}