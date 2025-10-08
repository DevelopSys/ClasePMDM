package model

class Moto(
    matricula: String,
    marca: String,
    modelo: String,
    km: Int,
    cv: Int,
    precio: Double,
    var alforjas: Boolean,
    var manillar: String
) : Vehiculo(matricula, marca, modelo, km, cv, precio), Coleccionable {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("alforjas = ${alforjas}")
        println("manillar = ${manillar}")
    }

    fun realizarCaballito(){
        if (!alforjas && manillar.equals("L",true)){
            println("Puedes hacer caballito")
        }
    }

    override fun incrementarValor() {
        precio *= 1.05
    }

}