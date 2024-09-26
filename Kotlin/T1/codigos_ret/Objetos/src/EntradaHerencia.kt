import controller.Colegio
import model.Alumno
import model.Profesor
import model.Usuario
import kotlin.reflect.typeOf

fun main() {
    var alumno = Alumno(
        "Borja", "Martin",
        "borja@gmail.com", 123123, "Dam", 2
    )
    //alumno.asistirClase()
    var profosor = Profesor("Luis", "Herrera", "luis@gmail.com",
        911111, 30000, true)
    //profosor.impartirClase()
    // JUNTAR POR POLIMORFISMO

    var alumno1 = Alumno("Borja","Martin","correo@gmail");

    var lista = ArrayList<Usuario>()
    lista.add(alumno)
    lista.add(profosor)

    lista.forEach {
        // ejecutar el metodo impartir clase

        //it.toString() // kotlin -> java
        println(it::class.simpleName)  // java
        if (it::class.simpleName.equals("Alumno",true)){
            (it as Alumno).asistirClase()
        } else {
            (it as Profesor).impartirClase()
        }
        // (it as Profesor).impartirClase()
    }

    var nombre = readln()
    var apellido = readln()
    var correo = readln()
    var telefono = readln().toInt()

    var curso = readln()
    var nivel = readln().toInt()

    var sueldo= readln().toInt()
    var autonomo= readln().toBoolean()

    var colegio = Colegio();

    colegio.agregarComun(Alumno(nombre, apellido, correo, telefono, curso, nivel))
    colegio.agregarComun(Profesor(nombre, apellido, correo, telefono, sueldo, autonomo))





}