import model.Camion
import model.Coche
import model.Coleccionable
import model.Moto
import model.Vehiculo
import kotlin.reflect.typeOf

fun main() {
    var suziki: Moto = Moto(
        "1234A", "Suziki", "CBR500",
        0, 200, 30000.0, false, "L"
    )


    var ford: Coche = Coche(
        "1234B", "ford", "focus",
        0, 120, 30000.0, 5, 650
    )

    var camion = Camion("1234C", "Scania", "ScaniaPlus",
        0, 700, 200000.0, 100000.0)

    val listaVehiculos: ArrayList<Vehiculo> = arrayListOf()
    listaVehiculos.add(ford)
    listaVehiculos.add(suziki)
    listaVehiculos.add(camion)


    listaVehiculos.forEach {
        if (it is Coleccionable){
            it.incrementarValor()
        }
        it.mostrarDatos()
    }
}