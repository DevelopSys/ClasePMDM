import controller.Empresa
import model.*

fun main() {

    val empresa: Empresa = Empresa();
    var asalariado: Trabajador = Asalariado("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,14);
    (asalariado as Asalariado).metodoAsalariado()
    var jefe: Jefe = Jefe("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,100.0,10);
    var directivo: Directivo = Directivo("2", "N1", "A1");

    /*empresa.agregarTrabajador(jefe)
    empresa.agregarTrabajador(directivo)
    empresa.registrarVoto(jefe);
    empresa.registrarVoto(directivo);
    empresa.mostrarResultadoVotacion()*/

    empresa.agregarTrabajador(Jefe("1", "N1", "A1", 1000.0, "asd", "123@correo", 123,100.0,10))
    empresa.agregarTrabajador(Jefe("2", "N2", "A1", 2000.0, "asd", "123@correo", 123,100.0,10))
    empresa.agregarTrabajador(Asalariado("3", "N3", "A1", 1000.0, "asd", "123@correo", 123,14))
    empresa.agregarTrabajador(Asalariado("4", "N4", "A1", 1000.0, "asd", "123@correo", 123,14))
    empresa.agregarTrabajador(Autonomo("5", "N5", "A1", 1000.0, "asd", "123@correo", 123,140))
    empresa.agregarTrabajador(Autonomo("6", "N6", "A1", 1000.0, "asd", "123@correo", 123,140))
    empresa.agregarTrabajador(Directivo("7", "N1", "A1"))
    empresa.agregarTrabajador(Directivo("8", "N1", "A1"))

    //empresa.mostrarDatosTrabajadores()
    //empresa.mostrarSueldos()
    empresa.comenzarVotacion()

    // agregar a la empresa 2 usuarios de cada tipo
    // mostrar los datos de todos las personas
    // mostrar el sueldo de todos los trabajadores
    // realizar votos de cada uno de los accionistas
    // ver resultado de la votación

}