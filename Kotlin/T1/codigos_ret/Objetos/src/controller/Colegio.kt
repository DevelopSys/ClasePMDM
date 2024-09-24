package controller

import model.Usuario

class Colegio() {

    var id: Int =0;
    val listaAlumnos: ArrayList<Usuario> = ArrayList()
    // []
    // agregar un alumno
    fun agregarAlumno(alumno: Usuario){
        id++;
        alumno.id = id;
        listaAlumnos.add(alumno)
    }

}