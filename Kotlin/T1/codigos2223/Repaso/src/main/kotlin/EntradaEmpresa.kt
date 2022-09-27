import model.Asalariado
import model.Empresa
import model.Jefe

fun main() {

    // trabajadores = null
    var empresa: Empresa = Empresa();
    empresa.agregarTrabajador(Asalariado("A1", "A1", "001", 1000, 12))
    empresa.agregarTrabajador(Asalariado("A2", "A2", "001", 1000, 12))
    empresa.agregarTrabajador(Asalariado("A3", "A3", "001", 1000, 12))
    empresa.agregarTrabajador(Asalariado("A4", "A4", "001", 1000, 12))
    empresa.agregarTrabajador(Jefe("J1", "J1", "002"))
    empresa.agregarTrabajador(Jefe("J2", "J2", "002"))
    empresa.agregarTrabajador(Jefe("J3", "J3", "002"))
    empresa.agregarTrabajador(Jefe("J4", "J4", "002"))
    empresa.agregarTrabajador(Jefe("J5", "J5", "002"))
    empresa.listarTrabajadores()

}