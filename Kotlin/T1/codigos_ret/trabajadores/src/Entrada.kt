import contoller.Empresa
import model.Asalariado
import model.Autonomo
import model.Jefe

fun main() {
    val empresa: Empresa = Empresa()
    empresa.contratar(Asalariado("Asalarido1", "Apellido1", "1234", 10000.0, true, 12))
    empresa.contratar(Asalariado("Asalarido2", "Apellido2", "2345", 20000.0, true, 15))
    empresa.contratar(Autonomo("Autonomo1", "Apellido2", "3456", 20000.0, 100, true))
    empresa.contratar(Autonomo("Autonomo2", "Apellido2", "5678", 20000.0, 100, true))
    empresa.contratar(Jefe("Jefe1", "Apellido1", "4567", 30000.0, 100.0, 50))

    //empresa.listar(2)
    empresa.despedir("4567","1234")
    empresa.listar(0)
}
