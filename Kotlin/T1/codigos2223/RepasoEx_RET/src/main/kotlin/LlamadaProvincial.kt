class LlamadaProvincial(nOrigen: Int, nDestino: Int, duracion: Int) : Llamada(nOrigen, nDestino, duracion) {

    // coste = 0
    // coste = duracion * 15

     init {
        coste = duracion * 0.15
     }

    override fun mostarDatos() {
        println("Llamada provincial")
        super.mostarDatos()
    }
}