package herencia

fun main() {
    var alumno1: Alumno = Alumno("Alumno1","Apellido1","1234A",20,"1234A")
    var alumno2: Alumno = Alumno("Alumno2","Apellido2","2345A",15)

    var profesor1: Profesor = Profesor("Profesor1", "Apellidos1", "3456A",20);
    var profesor2: Profesor = Profesor("Profesor2", "Apellidos2", "4567A",25,3000);

    //println(profesor2.salario)
    var listados = ArrayList<Persona>()
    listados.add(alumno1)
    listados.add(alumno2)
    listados.add(profesor1)
    listados.add(profesor2)

    println("Mostrando datos")
    listados.forEach({ persona: Persona -> persona.mostrarDatos() })

    profesor1::class.simpleName



}