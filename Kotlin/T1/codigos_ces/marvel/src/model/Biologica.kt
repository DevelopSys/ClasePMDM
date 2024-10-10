package model

class Biologica(
    id: Int? = null,
    nombre: String? = null,
    potencia: Int? = null,
    danio: Int? = null,
    var descripcion: String? = null
) : Arma(id, nombre, potencia, danio) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Descripcion: ${descripcion}")
    }
}