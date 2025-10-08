package model

class Coche(
    matricula: String,
    marca: String,
    modelo: String,
    km: Int,
    cv: Int,
    precio: Double,
    var nPuertas: Int,
    var capacidadMaletero: Int
) : Vehiculo(matricula,marca,modelo,km,cv,precio), Coleccionable {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nPuertas = ${nPuertas}")
        println("capacidadMaletero = ${capacidadMaletero}")
    }

    fun almacenarMaletero(elemento: Int){
        if (elemento<capacidadMaletero){
            println("Entra en el maletero")
        } else {
            println("Demasiado grande")
        }
    }

    override fun incrementarValor() {
        println("Vamos a ver como te coleccionas")
        precio *= 1.10;
    }

}