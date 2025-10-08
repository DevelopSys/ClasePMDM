package model

class Camion(
    matricula: String,
    marca: String,
    modelo: String,
    km: Int,
    cv: Int,
    precio: Double,
    var peso: Double
) : Vehiculo(matricula,marca,modelo,km,cv,precio) {

    fun realizarTransporte(kilos: Int){
      if (kilos<peso){
          println("Perfecto, procedemos al transporte")
      } else {
          println("No se puede transportar")
      }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("peso = ${peso}")
    }

}