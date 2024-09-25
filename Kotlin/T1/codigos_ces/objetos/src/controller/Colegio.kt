package controller

import model.Usuario

class Colegio(val CIF: String?=null) {

    // necesito una propiedad SI o SI -> va en el primario
    val listaAlumnos = ArrayList<Usuario>()

    // agregar un usuario -> FP o MASTER
    // -> no puede haber dos usuarios con el mismo correo

}