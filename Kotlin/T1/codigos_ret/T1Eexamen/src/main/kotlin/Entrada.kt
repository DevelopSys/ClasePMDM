import controller.Pizzeria
import model.Ingrediente
import model.Pizza
import java.nio.channels.Pipe

fun main() {


    var opcionMenu: Int = 0;
    val pizzeria: Pizzeria = Pizzeria();
    do {

         println("2. servir pizza")
        println("3. ver pendiente")
        println("4. ver caja")
        println("5. salir")
        println("Que quieres hacer")
        opcionMenu = readln().toInt()

        when (opcionMenu) {
            1 -> {
                println("Introduce nombre")
                val nombre: String = readln()
                println("Introduce id")
                val id: Int = readln().toInt()
                println("Intro nº ingredientes")
                val pizza = Pizza(id, nombre)
                val numeroIngredientes: Int = readln().toInt();
                (1..numeroIngredientes).forEach {
                    println("Introduce nombre ingrediente")
                    val nombreIngrediente: String = readln()
                    println("Introduce precio ingrediente")
                    val precioIngrediente: Double = readln().toDouble()
                    pizza.agregarIngrediente(Ingrediente(nombreIngrediente, precioIngrediente))
                }
                pizzeria.agregarPizza(pizza)
            }

            2 -> {
                println("Cual es el id de la pizza que quieres servid")
                var id = readln().toInt();
                pizzeria.servirPizza(id)
            }

            3 -> {
                pizzeria.listarPendientes()
            }

            4 -> {
                pizzeria.mostrarCaja()
            }
        }

    } while (opcionMenu != 5)

}