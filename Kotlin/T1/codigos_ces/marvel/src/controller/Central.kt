package controller

import model.*

class Central() {

    private val listaHeroes: ArrayList<Heroe> = ArrayList()
    private val listaArmas: ArrayList<Arma> = ArrayList()

    fun listarHeroes() {
        listaHeroes.forEach {
            it.mostrarDatos()
        }
    }

    fun listarArmas() {
        listaArmas.forEach {
            it.mostrarDatos()
        }
    }

    fun addHeroe(heroe: Heroe) {
        listaHeroes.add(heroe)
    }

    fun realizarCombate() {
        // listo los id de los heroes
        listaHeroes.forEach {
            println(it.id)
        }
        println("Indica que id quieres como combatiente 1")
        var id = readln().toInt();
        val combatiente1: Heroe? = listaHeroes.find { it.id == id }
        listaArmas.forEach {
            println(it.id)
        }
        println("Indica que id quieres como arma para el combatiente 1")
        id = readln().toInt();
        val arma1: Arma? = listaArmas.find { it.id == id }
        println("Indica que id quieres como combatiente 2")
        id = readln().toInt();
        val combatiente2: Heroe? = listaHeroes.find { it.id == id }
        println("Indica que id quieres como arma para el combatiente 2")
        id = readln().toInt();
        val arma2: Arma? = listaArmas.find { it.id == id }


        if (((combatiente1 is Humanos && arma1 is Tradicional) || (combatiente1 is Mutante && arma1 is Biologica)) &&
            ((combatiente2 is Humanos && arma2 is Tradicional) || (combatiente2 is Mutante && arma2 is Biologica))
        ) {
            println("Selecciones correctas")

            combatiente1.asociarArma(arma1)
            combatiente2.asociarArma(arma2)

            val resultadoC1 = arma1!!.danio?.let { arma1!!.potencia?.times(it)?.let { combatiente1!!.nivel?.plus(it) } }
            val resultadoC2 = combatiente2!!.nivel?.plus(arma2!!.potencia?.times(arma2!!.danio!!) ?: 0)

            if (resultadoC2!!>resultadoC1!!){
                println("Ganador ")
                combatiente2.mostrarDatos()
            } else {
                combatiente1.mostrarDatos()
            }

        } else {
            println("Selecciones incompatibles")
        }

    }

}