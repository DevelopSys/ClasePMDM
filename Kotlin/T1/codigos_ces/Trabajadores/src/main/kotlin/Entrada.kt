import model.Asalariado
import model.Autonomo
import model.Jefe
import model.Trabajador

fun main() {

    /*
    * nombre: String,
    apellido: String,
    dni: String,
    sueldo: Int = 10000,
    var numeroPagas: Int,
    var contratado: Boolean = false*/
    // Crear un asalariado sin sueldo
    println("Indica el nombre del trabajador")

    val asalariado1 = Asalariado("N1", "A1", "123A", 12000, 14);
    var asalariado2 = Asalariado("N2", "A2", "123B", 15000, 12);
    var autonomo1 = Autonomo("N3", "A2", "123B", 15000, 200, true);
    var autonomo2 = Autonomo("N4", "A2", "123B", 20000, 300, true);
    var jefe1 = Jefe("N5", "A2", "123B", 20000, 1000, 50);
    var jefe2 = Jefe("N6", "A2", "123B", 450000, 3000, 70);
    var listaTrabajadores: ArrayList<Trabajador> = ArrayList();
    listaTrabajadores.add(asalariado1)
    listaTrabajadores.add(asalariado2)
    listaTrabajadores.add(autonomo1)
    listaTrabajadores.add(autonomo2)
    listaTrabajadores.add(jefe2)
    listaTrabajadores.add(jefe1)

    listaTrabajadores.forEach { it.calcularSueldoNetoMes() }


}