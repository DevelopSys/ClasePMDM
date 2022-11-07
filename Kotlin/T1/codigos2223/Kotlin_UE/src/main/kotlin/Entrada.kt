// public void nombre(){}
fun main() {
    // complejas
    /*var nombre: String = "Borja"
    var edad: Int = 38;
    var carnet: Boolean? = null;
    println(carnet?.toString())
    println(nombre)

    // if ternario
    // condicion ? ejecuta_cuando_true : ejecuta_false
    // switch
    var numero = 5
    when(numero){
        1 -> {}
        2-> {}
    }*/

    /*var persona1 = Persona("Borja","Martin", 38);
    var persona2 = Persona("Borja","Martin", 38, "0009");

    persona1.mostrarDatos()
    persona2.mostrarDatos()*/

    var trabajador: Trabajador = Trabajador("Borja", "MArtin",38,12345);
    trabajador.funcionMostarDatos(3,"ejemplo")
    trabajador.nombre = "Valor nombre nuevo"
    println(trabajador.nombre)
    //trabajador.funcionUno()
    //println(trabajador.trabajoExtra)

    //trabajador.metodoAbs()
    //trabajador.mostrarDatos();

}