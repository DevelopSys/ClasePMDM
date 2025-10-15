import controller.Organizacion
import model.Humano
import model.Mutante

fun main() {
    val organizacion = Organizacion()

    var opcion: Int = 0;

    do {
        print("1-Listar armas")
        print("2-Listar superheroes")
        print("3-Agregar superheroes")
        print("4-Combatir superheroes")
        print("5- Salir")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                organizacion.listarArmas()
            }

            2 -> {
                organizacion.listarHeroes()
            }

            3 -> {
                print("Que tipo de heroe quieres crear(1-humanos,2-mutantes)")
                var opcionHeroe = readln().toInt()
                when (opcionHeroe) {
                    1 -> {
                        print("Indica id")
                        var id = readln().toInt();
                        print("Indica nombre")
                        var nombre = readln()
                        print("Indica nivel")
                        var nivel = readln().toInt()
                        print("Indica resistencia")
                        var resistencia = readln().toInt();
                        organizacion.agregarHeroe(Humano(id, nombre, nivel, resistencia))
                    }

                    2 -> {
                        print("Indica id")
                        var id = readln().toInt();
                        print("Indica nombre")
                        var nombre = readln()
                        print("Indica nivel")
                        var nivel = readln().toInt()
                        organizacion.agregarHeroe(Mutante(id, nombre, nivel))
                    }
                }

            }

            4 -> {
                print("Dime el id del op1")
                var idOp1 = readln().toInt()
                print("Dime el arma del op1")
                var armaOp1 = readln().toInt()
                print("Dime el id del op2")
                var idOp2 = readln().toInt()
                print("Dime el arma del op2")
                var armaOp2 = readln().toInt()
                organizacion.realizarCombate(idOp1, armaOp1, idOp2, armaOp2)
            }

            5 -> {}
        }


    } while (opcion != 5)



    organizacion.listarArmas()
}