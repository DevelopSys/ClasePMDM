// VARIABLES - FUNCIONES - CLASE

// FUNCIONES fun nombre(arg: Tipo){
// }

// FUNCIONES fun nombre(arg: Tipo): Tipo_retorno{
// return
// }
// p s v main(){}
fun main(arg: Array<String>) {

    // tipo nombre: Tipo = valor
    // var(normal) val(constante)
    // lateinit

    /*var nombre: String? = null;
    var edad:Int = 18;
    val DNI = "123456789A"

    //nombre = "Borja"
    println(nombre?.length ?: "Ejemplo")

    nombre = readLine();

    println("La longitud del nombre es ${nombre?.length ?: "Pepe"}")
    println("Primera ejecución de Kotlin")
    println("Hola son "+nombre+" y tengo "+edad+" años")
    println("Hola son ${nombre} y tengo ${edad}")
    println("La suma de los numeros 2 y 4 es ${2 + 4}")*/
    //estructuraIf();
    //estructuraFor();
    //ejercicioAleatorios();
    // while / dowhile / java igual que java
    //estructuraWhen()
    //funcionArrays()
    funcionListas();

}

fun funcionListas() {

    // List --> Listas mutables --> ArrayList
    var listaAlumnosKt = ArrayList<String>();
    listaAlumnosKt.add("Alumno1_");
    listaAlumnosKt.add("Alumno2");
    listaAlumnosKt.add("Alumno3_");
    listaAlumnosKt.add("Alumno4");
    listaAlumnosKt.add("Alumno5_");

    //println(listaAlumnosKt.get(0));
    //listaAlumnosKt.set(0,"AlumnoNuevo")
    //listaAlumnosKt.removeAt(0)
    //listaAlumnosKt.removeIf ({elemento-> elemento.contains("_")})
    //listaAlumnosKt.forEach ({ nombre -> println(nombre) })
    //listaAlumnosKt.forEach { if (it.length >5){} }
    //listaAlumnosKt.find { it.contains("_1") }

}

// fun nombre (parametros): Tipo_retorno --> Unit es el void de java
fun estructuraIf() {
    println("Estructura de control IF")
    // if (c) {} else {}
    // if (c) {} else if (c) {} else
    // var salida = if () else {}
    // no existe el if ternario

    var nombre: String? = null;
    println("Introduce tu nombre")
    nombre = readLine()

    // evaluar si la longitud del nombre es más grande que 5
    // en ese caso sacar por consola un "nombre demasiado grande"
    // en caso contrario sacar por consola "nombre correcto"

    // (null > 5) --> (7>5)
    if (nombre?.length!! > 5) {
        println("nombre demasiado largo")
    } else {
        println("nombre correcto")
    }
}

fun estructuraFor() {
    // for (int i=0;i<11;i++){}
    // for (i in 1..10){}
    /*for (i in 1..50 step 5){
        println(i)
        // (int) (Math.random() * 51)
        //var aleatorio = (1..50).random()
        //println(aleatorio)
    }*/
    // 1..10 10..1
    /*for (i in 10 downTo 0){
        println(i)
    }*/
    /*for (i in 10 until 20){
        println(i)
    }*/
    // 1 2 3 4 5 6 7 8 9 10
    // recorrer la coleccion de forma completa
    // coleccion.foreach( parametro (it) -> ejecucion)
    (1..10).forEach({ item ->
        println("Ejecucion del foreach")
        println(item)
    })
}

fun ejercicioAleatorios() {
    // generar 10 aleatorios entre el 1 y el 100, calculando:
    // la suma de todos
    // el numero medio
    // el numero max
    // el numero min

    // modificar el ejercicio anterior para que antes de empezar
    // pida la edad y compruebe si esta es mayor que 18. En caso de
    // ser así ejecutará lo anterior. En caso de no ser mayor de 18
    // saltará un aviso de que no se puede ejecutar

    var edad = 0;
    println("Por favor introduce tu edad")
    //edad = readLine() as Int;
    edad = readLine()!!.toInt();
    if (edad >= 18) {
        var sumatorio = 0;
        var max = -1;
        var min = 201;
        for (i in 1..10) {
            var aleatorio = (1..200).random();
            sumatorio += aleatorio;
            if (aleatorio > max) {
                max = aleatorio
            }
            if (aleatorio < min) {
                min = aleatorio
            }
        }
        println("La suma de los aleatorios es ${sumatorio}")
        println("El max de los aleatorios es ${max}")
        println("El min de los aleatorios es ${min}")
        println("La media de los aleatorios es ${sumatorio / 10}")
    } else {
        println("No tienes la edad requerida")
    }


}

fun estructuraWhen() {
    // when dato{
    //   valor -> {ejecuta}
    //   valor -> {ejecuta}
    //   valor -> {ejecuta}
    //   default -> {ejecuta}
    // }
    println("Por favor introduce la nota del examen")
    var nota = readLine()!!.toInt()
    when (nota) {
        in 5..10 -> {
            println("Examen aprobado")
        }
        in 0..4 -> {
            println("Examen suspenso")
        }
        !in 0..12 -> {
            println("nota incorrecta")
        }
        11 -> {
            println("nota incorrecta de 11")
        }
        // TODO ejecucion por metodo
        // si te paso 6 el caso es 12
        calculoNota(nota) -> {
            println("nota incorrecta de 12")
        }
    }
}

fun calculoNota(nota: Int): Int {
    return nota * 2;
}

fun funcionArrays() {
    // String[] arrayDecosas = new String[9]
    // String[] arrayDecosas = new String[]{"1","2","3","4",5","6"}
    // int[] array = new int[5] -> //0,0,0,0,0
    // [null,null,null,null,null]--> tiene valor
    var arrayPalabras: Array<String?> = arrayOfNulls<String>(5)
    //var arrayPalabrasDos: Array<String>?  = null;
    //arrayPalabras[0] = "Hola";
    arrayPalabras.set(0, "Hola")
    arrayPalabras[1] = "queasd";
    arrayPalabras[2] = "tal";
    arrayPalabras[3] = "estas";
    arrayPalabras[4] = "tu";

    //println(arrayPalabras.get(0))
    // for
    /*for(i in arrayPalabras){
        print(i+" ")
    }*/

    /*for (i in 0..arrayPalabras.size-1){
        println(arrayPalabras.get(i))
    }*/
    // foreach
    //arrayPalabras.forEach({ palabra -> println(palabra) })

    arrayPalabras.forEachIndexed({ index, value -> println("${index} ${value}") })
    // hacer una busqueda de solo sacar
    // hola(0)SI que(1) tal(2)SI estas(3) tu(4)SI
    // las palabras que están en posiciones pares
    arrayPalabras.forEachIndexed { index, value -> if (index % 2 == 0) println(value) }
    // las palanras que tengan una longitud de al menos 5 de longigud
    arrayPalabras.forEach { value-> if (value?.length!! >= 5) println(value) }
    println("Filtrado: ")
    // las palabras que tengan una longitud de al menos 5 de longigud
    var listaFiltrada = arrayPalabras.filter ({value -> value?.length!! >=5 })
    listaFiltrada.forEach({ println(it) })
}