package controller

import model.Usuario

class Colegio() {

    var id: Int = 0;
    val listaAlumnos: ArrayList<Usuario> = ArrayList()

    // []
    // agregar un alumno
    fun agregarAlumno(alumno: Usuario) {
        id++;
        alumno.id = id;
        listaAlumnos.add(alumno)
        println("Alumno agregado correctamente")
    }

    fun desmatricular(id: Int) {
        val encontrado: Usuario? = listaAlumnos.find {
            it.id == id
        }
        encontrado?.desmatricular() ?: println("No se ha encontra el alumno")
        if (encontrado != null) {
            println("Desmatriculado alumno con nombre ${encontrado.nombre}")
        }
        /*if (encontrado!=null){
    encontrado!!.desmatricular()
} else {
    println("No se encuentra un alumno con el id aportado")
}*/
    }

    fun listarAlumno(opcion : Int) {
        if (!listaAlumnos.isEmpty()) {
            var opcionMatricula= false;
            if (opcion==1){
                opcionMatricula = true;
            } else if (opcion==2){
                opcionMatricula = false;
            }

            when(opcion){
                1->{
                    listaAlumnos.forEach {
                        it.mostrarDatos()
                    }
                }
                2->{
                    // matriculados
                    listaAlumnos.filter { it.matriculado }.forEach { it.mostrarDatos() }
                }
                3->{
                    // desmatriculados
                    listaAlumnos.filter { !it.matriculado }.forEach { it.mostrarDatos() }
                }
            }
        } else {
            println("No hay alumnos en la lista")
        }
    }

    fun calificarAlumno(id: Int) {

        // listaAlumnos.find { it.id == id }?.calificacion= calificacionNota ?: println("No se encuentra el usuario")
        var encontrado: Usuario? = listaAlumnos.find { it.id == id }
        if (encontrado != null) {
            var calificacionNota: Double = 0.0;
            do {
                println("Indica la calificacion que quieres poner")
                calificacionNota = readln().toDouble()
            } while (calificacionNota < 0 || calificacionNota > 10)
            encontrado.calificacion = calificacionNota;
        } else {
            println("Alumno no encontrado")
        }
    }

}