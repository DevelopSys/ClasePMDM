import model.Asalariado
import model.Autonomo
import model.Directivo
import model.Jefe
import model.Persona
import model.Sindicato
import model.Trabajador
import kotlin.reflect.typeOf

fun main() {


    // var persona = Persona("Borja", "Martin","123A")
    // persona.mostrarDatos()
    // var trabajador = Trabajador("Borja","Martin","1234A",40000,12,true,91111111,"borja@gmail.com")
    val asalariado = Asalariado("BorjaAs", "Martin", "1234A", 40000.0, 12, 0.10)
    val autonomo = Autonomo("BorjaAu", "Martin", "1234A", 40000.0, true, 300)
    val jefe = Jefe("BorjaJf", "Martin", "1234A", 40000.0, 4)
    val directivo = Directivo("BorjaDr", "Martin", "1234A", 123123, "directivo@gmail.com", 54)
    val trabajadores = arrayListOf<Persona>(asalariado, autonomo, jefe, directivo)
    /*trabajadores.forEach {
        // si eres de tipo Trabajador -> calcule el salario
        it.mostrarDatos()
        if (it is Trabajador) {
            println("Calculando salario del trabajador: ${it.calcularSalarioNeto()}")
        }
    }*/

    // calcular beneficios

    // Para poder bajar sueldos, un jefe solo bajara los sueldos
    // a los trabajadores que no son jefes
    // la cantidad de salario que puede bajar es del 10%
    // En caso de ser un directivo, le podré bajar el sueldo a todos los trabajador
    // incluido a los jefes. un 20% a los Asalariados / Autonomos
    // un 10% a los jefes


    trabajadores.forEach {
        if (it is Sindicato) {
            it.bajarSueldos(trabajadores.filter { it !is Directivo }
                    as ArrayList<Trabajador>)
        }
    }


}