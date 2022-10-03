class Centralita() {

    lateinit var listaLLamadas: ArrayList<Llamada>;
    var costeTotal: Int = 0;

    init {
        listaLLamadas = ArrayList();
    }

    fun agregarLlamada(llamada: Llamada) {
        listaLLamadas.add(llamada)
        costeTotal += llamada.coste;
    }

    fun mostrarCostes() {
        println("El coste acumulado es: $costeTotal")
    }

    fun listarLlamadas() {
        listaLLamadas.forEachIndexed({ index, item ->
            print("Llamada en la posición ${index + 1} ")
            item.mostrarDatos()
        })
    }

    fun listarConFiltro(tipo: String) {
        listaLLamadas.forEach {

            if (it::class.simpleName == tipo){
                it.mostrarDatos()
            }


        }
    }


}