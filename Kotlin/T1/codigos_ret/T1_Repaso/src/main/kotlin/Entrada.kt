import controller.Ciclo
import model.Alumno
import model.Profesor
import model.Proyecto

fun main() {


    var opcion = 0;
    var ciclo = Ciclo()
    var nombre: String;
    var apellido: String;
    var dni: String;

    do {
        println("1. Add alumno")
        println("2. Add profesor")
        println("3. Add proyecto")
        println("4. List proyecto")
        println("5. Salir")
        println("Introduce la opcion deseada")
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                println("Introduce nombre")
                nombre = readln();
                println("Introduce apellido")
                apellido = readln();
                println("Introduce dni")
                dni = readln();
                ciclo.addAlumno(Alumno(nombre, apellido, dni)))
                /*if(ciclo.getAlumno(dni)!=null){
                    ciclo.addAlumno(Alumno(nombre,apellido,dni))
                    println("Alumno agregado correctamente")
                } else {
                    println("No es posible, ya existe")
                }*/
            }

            2 -> {
                println("Introduce nombre")
                nombre = readln();
                println("Introduce apellido")
                apellido = readln();
                println("Introduce dni")
                dni = readln();
                ciclo.addProfesor(Profesor(nombre, apellido, dni)))
            }

            3 -> {
                println("Introduce titulo")
                var titulo: String = readln()
                println("Introduce descripcion")
                var desc: String = readln()
                println("Introduce conentenido")
                var contenido: String = readln()

                var profesor: Profesor?
                do {
                    println("Introduce DNI profesor")
                    dni = readln()
                    profesor = ciclo.getProfesor(dni);
                } while (profesor == null)

                var integrante: Alumno?;
                var numeroIntegrantes = 0;
                do {
                    println("Intro dni del integrante")
                    dni = readln();
                    integrante = ciclo.getAlumno(dni)
                    if (integrante != null) {
                        numeroIntegrantes++
                    }
                } while (integrante == null || numeroIntegrantes == 3)



                ciclo.addProyecto(Proyecto(titulo, desc, profesor, contenido);

            }

            4 -> {
                ciclo.listarProyectos()
            }
        }

    } while (opcion != 5);

}