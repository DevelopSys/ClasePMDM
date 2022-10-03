fun main() {

    var centralita: Centralita = Centralita();
    centralita.agregarLlamada(LlamadaLocal(123,123,10))
    centralita.agregarLlamada(LlamadaNacional(234,234,20,1));
    centralita.agregarLlamada(LlamadaProvincial(345,345,30));

    //centralita.listarLlamadas();
    centralita.mostrarCostes()

    var opcion: Int = 0
    do{

        println("Opcion 1")
        println("Opcion 2")
        println("Opcion 3")
        opcion = readln().toInt();
        when(opcion){
            1->{
                var nOrigen = readln().toInt();
                var nDestino = readln().toInt();
                var duracion = readln().toInt();
                var franja = readln().toInt();
                centralita.agregarLlamada(LlamadaNacional(nOrigen,nDestino,duracion,franja))
            }
            2->{}
            3->{}
            4->{centralita.mostrarCostes()}
        }

    }while (opcion!=4);



}