package model

class Person(val name: String, val surname: String, val dni: String){

var email: String? = null;

constructor(nameS: String, surnameS: String, dniS: String, email: String)
: this(nameS,  surnameS, dniS)
{
    this.email = email;
}

fun mostrarDatos(): Unit{

    println("Name = ${name}")
    println("Surname = ${surname}")
    println("Dni = ${dni}")


}
}