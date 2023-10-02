import controller.Empresa
import model.*

fun main() {

    val empresa: Empresa = Empresa();


    var asalariado: Trabajador = Asalariado("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,14);
    (asalariado as Asalariado).metodoAsalariado()
    var jefe: Trabajador = Jefe("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,100.0,10);





    empresa.agregarTrabajador(Jefe("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,100.0,10))
    empresa.agregarTrabajador(Asalariado("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,14))
    empresa.agregarTrabajador(Autonomo("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,140))

}