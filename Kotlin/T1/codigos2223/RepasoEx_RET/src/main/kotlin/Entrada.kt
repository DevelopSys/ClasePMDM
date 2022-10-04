fun main() {

    var centralita = Centralita();
    centralita.registrarLlamada(LlamadaLocal(1,2,3,"Alcorcón"))
    centralita.registrarLlamada(LlamadaLocal(1,2,3,"Pozuelo"))
    centralita.registrarLlamada(LlamadaNacional(1,2,3,1))
    centralita.registrarLlamada(LlamadaNacional(1,2,3,1))
    centralita.registrarLlamada(LlamadaProvincial(1,2,3))
    centralita.registrarLlamada(LlamadaProvincial(1,2,3))

    //centralita.listarLlamadas()

    centralita.mostrarCostesAcumulados()

}