var nombre: String = "Borja"
    get() {
       return field
    }


var edad: Int = 39
    get() {
        return field
    }

    set(value) {
        field = field+value
    }

fun main(args: Array<String>) {

    edad = 1

    println("El nombre guarado es $nombre $edad")
}

