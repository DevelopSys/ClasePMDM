fun main(){



    do {
        println("1- Opcion 1")
        println("2- Opcion 2")
        println("3- Salir")
        println("Indica que opcion queres hacer")
        var opcion = readln().toInt()
        when(opcion){
            1->{
                println("Seleccionado 1")
            }
            2->{
                println("Seleccionado 2")
            }
            3->{
                println("Saliendo")
            }
            else -> {
                println("No contemplado")
            }
        }
    } while (opcion!=3)




}