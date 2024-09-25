import controller.Colegio
import model.Alumno
import model.Usuario

fun main() {

    
    var opcion = 0;
    val colegio: Colegio = Colegio()
    // [werwer,3321321]

    do {
        println("1. Agrega alumno")
        println("2. Desmatricular alumno")
        println("3. Listar alumnos")
        println("4. Calificar alumno")
        println("5. Salir")
        println("Indica opcion")
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                println("AGREGANDO ALUMNO")
                println("Indica el nombre a agregar")
                var nombre = readln();
                println("Indica el apellido a agregar")
                var apellido = readln();
                colegio.agregarAlumno(Usuario(nombre, apellido))
                // agregar alumnos
                // pedir los datos, crear el obejto y meterlo dento de la lista
                // colegio.agregarUsuario(usuario)
            }

            2 -> {
                // id
                println("Por favor indica el id del alumno que quieres desmatricular")
                var id = readln().toInt()
                colegio.desmatricular(id)
            }

            3 -> {
                // 1-> todos
                // 2-> matriculados
                // 3-> no matriculados
                println("Indica que listado quieres mostrar")
                println("1- todos")
                println("2- matriculados")
                println("3- desmatricualdos")
                var opcionListado = readln().toInt()
                colegio.listarAlumno(opcionListado)
            }

            4 -> {
                println("Por favor indica el id del alumno que quieres calificar")
                var id = readln().toInt()
                colegio.calificarAlumno(id)
            }

            5 -> {
                println("Saliendo...")
            }

            else -> {
                println("Opcion no valida, intentalo de nuevo")
            }
        }

    } while (opcion != 5)

    // instanciar objetos
    /*
    var alumno1: Usuario = Usuario("Borja","Martin")
    // nombre = "Borja"
    // apellido = "Martin"
    // correo = null
    var alumno2: Usuario = Usuario("Juan","Gomez")
    // nombre = "Juan"
    // apellido = "Gomez"
    // correo = null
    var alumno3: Usuario = Usuario("Pedro", "Gimenez")
    // nombre = "Pedro"
    // apellido = "Cosa"
    // correo = null
    var alumno4: Usuario = Usuario(null,null)
    // nombre = null
    // apellido = null
    // correo = null
    var alumno5: Usuario = Usuario()
    // nombre = null
    // apellido = null
    // correo = null
    var usuario6: Usuario = Usuario("Luis","Aguado",
        "luis@aguado.com")
    // nombre = Luis
    // apellido = Aguado
    // correo = luis@aguado.com
    var usuario7: Usuario = Usuario("Luis","Aguado",
        "correo",91222222)
    // nombre = Luis
    // apellido = Aguado
    // telefono = 91222222
    // correo = null
    var usuario8: Usuario = Usuario("Luis","Aguado", telefono = 91222222)*/
    var alumno1 = Usuario("Borja", "Martin")
    alumno1.mostrarDatos()
    var alumno2 = Usuario("Luis", "Gomez", correo = "luis@gmail.com")
    alumno2.mostrarDatos()

    val alumnos = ArrayList<Usuario>()
    alumnos.add(alumno2)
    alumnos.add(alumno1)
    alumnos.add(Usuario("Claudia", "Martin", telefono = 123123))
    alumnos.add(Usuario("Juan", "Lopez", correo = "juan@gmail.com"))
    alumnos.add(Usuario("Pepe", "Gomez"))

    alumnos[3].desmatricular();
    alumnos[1].desmatricular();

    println("Actualmente la lista de alumnos es de ${alumnos.size}")
    println("El alumno que esta en la primera posicion es ${alumnos[0].nombre}")

    /*for (i in alumnos) {
        i.mostrarDatos()
    }

    for (i in 0 until alumnos.size) {
        alumnos[i].mostrarDatos()
    }

    alumnos.forEach { it.mostrarDatos() }*/
    /*alumnos.forEachIndexed { index, usuario ->
        //println("En la posicion $index esta ${usuario.nombre}")
        if(!usuario.matriculado){
            usuario.mostrarDatos()
        }
    }*/
    // la lista de los matriculados
    val matriculados: List<Usuario> = alumnos.filter { it.matriculado }
    // alumnos.filter {it.matriculado}.forEach { it.mostrarDatos() }
    // diferencia entre un LIST y un ARRAYLIST ->
}