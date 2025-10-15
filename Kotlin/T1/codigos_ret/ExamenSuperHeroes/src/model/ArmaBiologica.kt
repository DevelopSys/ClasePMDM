package model

class ArmaBiologica(id: Int, nombre: String,
                    potencia:Int,
                    danio: Int,
                    var descripcion: String):
    Arma(id,nombre,potencia,danio) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("descripcion = ${descripcion}")
    }

}