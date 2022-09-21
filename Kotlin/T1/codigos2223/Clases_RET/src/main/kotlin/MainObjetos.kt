import model.Coche
import model.Propietario

fun main() {
    //[cv = 0]
    var coche1 = Coche("Mercedes", "C220");
    var coche2 = Coche("Ford", "Fiesta");
    /*coche1.mostrarDatos()
    coche1.calcularParMotor({aceleracion->aceleracion*2},10)
    coche2.calcularParMotor({aceleracion->aceleracion*1},10)*/
    //coche1.setCV(100)
    //println(coche1.getCV())
    //var coche2 = Coche("Mercedes","C300","1234A");
    coche1.asignarPropietario(Propietario("B","M","1234A"))
    println(coche1.propietario)
}