class Centralita {

    lateinit var listaLlamadas: ArrayList<Llamada>;

    init {
        listaLlamadas = ArrayList();
    }

    fun registrarLlamada(llamada: Llamada) {

        if (llamada is LlamadaNacional &&
            (listaLlamadas.filter { it.javaClass.simpleName == "LlamadasNacionales" }).size < 4
        ) {

            listaLlamadas.add(llamada)
        } else {
            println("Llamadas nacionales copadas")
        }
        print("Llamada registrada con datos: ")
        llamada.mostarDatos()
    }

    fun listarLlamadas() {
        listaLlamadas.forEachIndexed({ index, llamada ->
            llamada.mostarDatos()
        })
    }

    fun mostrarCostesAcumulados() {
        var costeAcumulado: Double = 0.0;
        listaLlamadas.forEach {
            costeAcumulado += it.coste
        }
        println("El coste acumulado es de: $costeAcumulado")
    }

    // me dicen que tipo de llamada quiero listar
    // y solo listo esas llamadas
    fun listarConFiltro(clase: String) {
        listaLlamadas.forEach({
            if (it.javaClass.simpleName == clase) {
                it.mostarDatos()
            }
        })

        listaLlamadas.forEach({
            if (it::class.simpleName == clase) {
                it.mostarDatos()
            }
        })


    }

    fun filtradoNumero() {

        println((listaLlamadas.filter { it.javaClass.simpleName == "LlamadasNacional" }).size)
        println((listaLlamadas.filter { it.javaClass.simpleName == "LlamadaLocal" }).size)
        println((listaLlamadas.filter { it.javaClass.simpleName == "LlamadaProvincial" }).size)

    }


}