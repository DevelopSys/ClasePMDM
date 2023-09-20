fun main() {

    //var arrayVacio: Array<String> = emptyArray();
    // int[] numeros = new inte[10]
    var arrayVacio: Array<String?> = arrayOfNulls<String>(10);
    var arrayElementos: Array<Any?> = arrayOf(1, 6, 3, 4, 5, "asd", 7, 3)
    var arrayElementosInt: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    var arrayNumeros = intArrayOf(1, 2, 3, 4, 5, 6, 7)

    // obtener dato

    //println(arrayElementos[0])

    arrayElementos[3] = null
    arrayElementos.forEach { // it
        println(it ?: "sin dato guardado en la posicion")
    }

    // encontrar en un array cuantos 3
    var contador = 0;
    /*arrayElementos.forEach {
        if (it == 3){
            contador++;
        }
    }*/

    var lista: List<Any?> = arrayElementos.filter { it == 3 }
    println("El numero de 3 es ${arrayElementos.filter { it == 3 }.size}")


    var listaElementos = ArrayList<String>()
    listaElementos.add("123456")
    listaElementos[1] = "2345678"
    listaElementos.get(0)
    listaElementos[0]
    listaElementos.remove("qwertyu")
    listaElementos.removeIf { it.equals("qwe",true) }



    /*for (i in arrayElementos){
        println(i)
    }*/


}