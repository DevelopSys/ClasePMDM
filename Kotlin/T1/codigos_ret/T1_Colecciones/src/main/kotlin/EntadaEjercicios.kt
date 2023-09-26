fun main(args: Array<String>) {
    //ejercicioUno()
    //ejercicioCuatro()
    //ejercicioCinco()
    //ejercicioSeis()
    //ejercicioSiete()
    ejercicioNueve()

}

fun ejercicioNueve(): Unit {
    var arrayNumeros = arrayOf(1,2,3,4,5,6,7,8,9)
    // cortar palabra "ejemplo" slice (4)  slice (0,3)
    arrayNumeros.slice(2..6).forEach { println(it) }
}

fun ejercicioSiete(): Unit {
    val arrayPeliculas = arrayOf("PPelicula1","PPelicula2","PPelicula3","PPelicula4","PPelicula5")
    println(arrayPeliculas.joinToString { it }.length)
}

fun ejercicioSeis(): Unit {
    val arrayNumeros = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arrayNumeros.reduce { acc, i ->
        acc + i
    })
}

fun ejercicioCinco() {
    val arrayNumeros = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    arrayNumeros.map { println(it * 2) }
}

fun ejercicioCuatro(): Unit {
    val arrayNombre = arrayOf<String>("Borja", "Maria", "Marco", "Juanc")
    println(arrayNombre.find { it.contains("c") })
}

fun ejercicioTres(): Unit {
    val numeros = arrayOf(1, 2, 3, 123, 123, 123, 123, 123, 32, 3, 43, 4, 54, 3, 543)
    numeros.forEach {
        if (it % 2 != 0) print(it)
    }

    numeros.filter { it % 2 != 0 }.forEach { println(it) }
}

fun ejercicioUno(): Unit {
    val arrayNombres = arrayOf("Borja", "Juan", "Luis", "Pedro", "Maria")
    arrayNombres.forEach { println(it) }
}