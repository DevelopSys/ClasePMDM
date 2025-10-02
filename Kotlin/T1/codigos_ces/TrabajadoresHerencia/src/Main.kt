import model.Persona
import model.Trabajador

fun main() {
    // var persona = Persona("Borja", "Martin","123A")
    // persona.mostrarDatos()
    var trabajador = Trabajador("Borja","Martin","1234A",
        40000,12,true,91111111,"borja@gmail.com")
    trabajador.mostrarDatos()
}