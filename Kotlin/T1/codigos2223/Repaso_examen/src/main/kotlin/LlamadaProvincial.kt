class LlamadaProvincial (numeroOrigen: Int, numeroDestino: Int, duracion: Int):
    Llamada(numeroOrigen, numeroDestino, duracion) {

    var provincia: String? = null;

    constructor(numeroOrigen: Int, numeroDestino: Int, duracion: Int, provincia: String):
            this(numeroOrigen,numeroDestino,duracion){
                // super(asd,asd,asd)
                this.provincia = provincia;
    }

    init {
       coste = duracion * 15;
    }

    override fun mostrarDatos() {
        println("Llamada provincial")
        super.mostrarDatos()
        println("Coste por segundos: 15")
    }

}