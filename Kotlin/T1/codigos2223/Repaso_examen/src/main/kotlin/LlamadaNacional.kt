class LlamadaNacional(numeroOrigen: Int, numeroDestino: Int, duracion: Int, var franja: Int) :
    Llamada(numeroOrigen, numeroDestino, duracion) {

    init {
        when (franja) {
            1 -> {
                coste = duracion * 20;
            }
            2 -> {
                coste = duracion * 25;
            }
            3 -> {
                coste = duracion * 30;
            }
        }
    }

    override fun mostrarDatos() {
        println("Llamada Nacional")
        super.mostrarDatos()
        println("Franja " + franja);
    }
}