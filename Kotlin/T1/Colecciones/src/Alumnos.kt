/*
    Realizar una aplicacion que
    decida que alumno de la clase saldra a mostrar la solucion de los ejercicios
    1. Un menu donde tenga las siguientes opciones
        1. Crear clase -> indica cuantos alumnos hay en la clase
        2. Matricular alumnos -> pedirá los nombre de todos los alumnos (puede haber nombres repetidos)
        3. Mostrar alumnos clase -> mostrará los nombres de todos los alumnos disponibles (los nulos no los mostrará)
        4. Sacar alumno a pizarra -> mostrará el nombre del alumno que saldrá a la pizarra. Solo funcionara si todos
        los alumnos están matriculados . En caso de no estar llena, mostrará un aviso

     */

lateinit var alumnos: Array<String?>

fun main() {
    var opcion = 0

    do {
        println("1. Crear clase")
        println("2. Matricular alumnos")
        println("3. Mostrar")
        println("4. Obtener random")
        println("Introduce la opcion a realizar")
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                if (alumnos.find { it != null } != null) {
                    println("Quiere resetear la clase")
                    // llamada a la inicializacion de la clase
                }
                println("Cuantos alumnos tiene tu clase")
                var numAlumno = readln().toInt()
                alumnos = arrayOfNulls(numAlumno)
            }

            2 -> {
                // comprobar si hay nulos
                (0..alumnos.size - 1).forEach {
                    println("Introduce el nombre del alumno en posicion ${it + 1}")
                    alumnos[it] = readln()
                }
            }

            3 -> {
                // comprobar si hay nulos

                alumnos.forEach {
                    println(it)
                }
            }

            4 -> {
                // comprobar si hay nulos
                println(alumnos.random())
                println(alumnos.filter { it !=null }.random())
            }

            5 -> {}
        }
    } while (opcion != 5)
}