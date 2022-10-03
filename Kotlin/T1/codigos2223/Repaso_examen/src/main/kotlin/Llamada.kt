open abstract class Llamada (private var numeroOrigen: Int, private var numeroDestino: Int, private var duracion: Int){

    var coste: Int =0

    open fun mostrarDatos(){
        println("Numero origen $numeroOrigen")
        println("Numero destino $numeroDestino")
        println("Numero duración $duracion")
        println("Coste $coste")

    }

    fun setNumeroOrigen(numeroOrigen: Int){
        this.numeroOrigen = numeroOrigen;
    }

    fun getNumeroOrigen(): Int{
        return this.numeroOrigen;
    }


}