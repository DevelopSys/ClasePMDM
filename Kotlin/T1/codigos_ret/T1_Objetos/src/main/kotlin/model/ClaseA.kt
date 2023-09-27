package model

class ClaseA(nombre: String, apellido: String, pass: String, correo: String, telefono: Int, var salario: Int) :
    Trabajador(nombre, apellido, pass, correo, telefono) {

    var salarioNeto: Int? = 0

    constructor(
        nombre: String,
        apellido: String,
        pass: String,
        correo: String,
        telefono: Int,
        salario: Int,
        sueldoNeto: Int
    )
            : this(nombre, apellido, pass, correo, telefono, salario) {
    }


}