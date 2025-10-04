import model.Coche
import model.Moto
import model.Vehiculo
import kotlin.reflect.typeOf

fun main() {
    var suziki: Moto = Moto(
        "1234A", "Suziki", "CBR500",
        0, 200, 20000.0,false,"L")


    var ford = Coche(
        "1234B", "ford", "focus",
        0, 120, 30000.0,5,650)


    val listaVehiculos: ArrayList<Vehiculo> = arrayListOf()
    listaVehiculos.add(ford)
    listaVehiculos.add(suziki)


    listaVehiculos.forEach {
        it.mostrarDatos()

    }
}