class LlamadaLocal(nOrigen: Int, nDestino: Int, duracion: Int) : Llamada(nOrigen, nDestino, duracion) {

    private var localidad: String? = null;

    constructor(nOrigen: Int, nDestino: Int, duracion: Int, localidad: String) : this(nOrigen,nDestino,duracion) {
        // setter
        this.localidad = localidad;
    }

    // coste = 0
    override fun mostarDatos() {
        println("Llamad Local")
        super.mostarDatos()
        println("Localidad $localidad")
    }

}