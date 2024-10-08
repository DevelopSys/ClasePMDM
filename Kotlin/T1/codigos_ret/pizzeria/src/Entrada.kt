import controller.Pizzeria
import model.Ingrediente
import model.Pizza

fun main() {
    // var pizza = Pizza(1,"margarita")
    var pizzeria = Pizzeria();
    var opcion: Int = 0;
    do {
        println("1. Agregar pizza")
        println("2. Ver estado")
        println("3. Ver pendientes")
        println("4. Ver caja")
        println("5. Salir")
        println("Que quieres hacer")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                // add pizza
                println("Indicame el id de la pizza")
                var id = readln().toInt()
                println("Indicame el nombre asociado de la pizza")
                var nombre = readln();
                var numIngredientes: Int = 0

                do {
                    println("Cuantos ingredientes tiene")
                    numIngredientes = readln().toInt()
                } while (numIngredientes > 9);
                var pizza = Pizza(id, nombre)
                for (i in 0..numIngredientes-1) {
                    println("Dime como se llama el ingrediente")
                    var nombreIng = readln();
                    println("Cuanto cuesta el ingrediente")
                    var precioIng = readln().toDouble();
                    var ingrediente = Ingrediente(nombreIng, precioIng)
                    pizza.agregarIngrediente(ingrediente)
                }
                pizzeria.agregarPizza(pizza)

            }
            2 -> {
                println("Indicame el id de la pizza que quieres ver")
                var id: Int = readln().toInt()
                pizzeria.verEstado(id)
            }
            3 -> {
                pizzeria.verPedientes()
            }
            4 -> {
                println("La caja del dia de hoy es ${pizzeria.caja}")
            }
            5 -> {
                println("Saliendo")
            }

            else -> {
                println("Opcion incorrecta, introduce un valor valido")
            }
        }


    } while (opcion != 5);
}