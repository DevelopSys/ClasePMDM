class LlamadaLocal(numeroOrigen: Int, numeroDestino: Int, duracion: Int)
    : Llamada(numeroOrigen, numeroDestino, duracion) {

    override fun mostrarDatos() {
        println("Llamada Local")
        super.mostrarDatos()

    }

}