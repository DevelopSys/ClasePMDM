fun main() {
    //funcionParametros("Borja",10);
    //funcionParametros(arg2 = 10,arg1 = "Borja");
    //funcionPorDefecto(numeroDos = 10, numeroTres = 20);
}

fun funcionSimple(){
    println("Funcion simple ejecutada")

}
fun funcionParametros(arg1: String, arg2: Int){
    println("$arg1")
    println("$arg2")
}
fun funcionPorDefecto(numeroUno: Int =100, numeroDos: Int, numeroTres: Int){
    println("${numeroUno+numeroDos+numeroTres}")
}
fun funcionSuma(num1: Int, num2: Int) = println("${num1+num2}")
fun funcionRetorno():String {
    return "Borja";
}