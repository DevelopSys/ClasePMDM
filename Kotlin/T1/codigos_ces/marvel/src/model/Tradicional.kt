package model

class Tradicional(
    id: Int? = null,
    nombre: String? = null,
    potencia: Int? = null,
    danio: Int? = null, var peso: Int? = null
) : Arma(id, nombre, potencia, danio) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Peso: $peso")
    }
}