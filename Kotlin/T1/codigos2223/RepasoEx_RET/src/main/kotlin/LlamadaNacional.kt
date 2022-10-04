class LlamadaNacional(nOrigen: Int, nDestino: Int, duracion: Int, var franja: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    // coste = franja * duracion

    init {
        when (franja) {
            1 -> { coste = duracion * 0.20 }
            2 -> { coste = duracion * 0.25 }
            3 -> { coste = duracion * 0.30 }
            else -> {
                // franja no registrada
            }
        }
    }

    override fun mostarDatos() {
        println("Llamada nacional")
        super.mostarDatos()
        println("Franja ${franja}")
    }

}