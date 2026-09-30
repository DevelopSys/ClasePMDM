fun main() {


    var carta = Carta("1C")
    var palos = arrayOf("P", "T", "C", "D")
    var baraja: ArrayList<Carta> = arrayListOf()
    palos.forEach { p ->
        (1..13).forEach { n ->
            when (n) {
                11 -> {
                    println("J$p")
                }

                12 -> {
                    println("Q$p")
                }

                13 -> {
                    println("K$p")
                }
                else -> {
                    baraja.add(Carta("$n$p"))
                }
            }
        }
    }

    baraja.random().valor


    var controller = Controller();
    controller.addPerson(Trabajador())
    controller.addPerson(Director())
    controller.personas.forEach {
        it.abstractMethod2()
    }
}