package controller

import model.Arma
import model.ArmaBiologica
import model.ArmaTradicional
import model.Humano
import model.Mutante
import model.SuperHeroe

class Organizacion() {

    var listaArmas: ArrayList<Arma> = arrayListOf()
    var listaHeroes: ArrayList<SuperHeroe> = arrayListOf()

    init {
        listaArmas.add(ArmaTradicional(1, "Martillo Thor1", 120, 100, 30))
        listaArmas.add(ArmaTradicional(2, "Martillo Thor2", 10, 400, 30))
        listaArmas.add(ArmaTradicional(3, "Martillo Thor3", 50, 300, 30))
        listaArmas.add(ArmaTradicional(4, "Martillo Thor4", 70, 200, 30))
        listaArmas.add(ArmaTradicional(5, "Martillo Thor5", 90, 700, 30))
        listaArmas.add(ArmaBiologica(6, "Veneno Mantis1", 900, 700, "Este veneno es muy malo"))
        listaArmas.add(ArmaBiologica(7, "Veneno Mantis2", 800, 600, "Este veneno es muy malo"))
        listaArmas.add(ArmaBiologica(8, "Veneno Mantis3", 700, 500, "Este veneno es muy malo"))
        listaArmas.add(ArmaBiologica(9, "Veneno Mantis4", 600, 550, "Este veneno es muy malo"))
        listaArmas.add(ArmaBiologica(10, "Veneno Mantis5", 950, 7050, "Este veneno es muy malo"))

    }

    fun agregarHeroe(heroe: SuperHeroe) {
        listaHeroes.add(heroe)
    }

    fun listarArmas() {
        listaArmas.forEach {
            it.mostrarDatos()
        }
    }

    fun listarHeroes() {
        listaHeroes.forEach {
            it.mostrarDatos()
        }
    }

    fun realizarCombate(idHeroe1: Int, idArma1: Int, idHeroe2: Int, idArma2: Int) {
        var oponente1 = listaHeroes.find { it.id == idHeroe1 }
        var arma1 = listaArmas.find { it.id == idArma1 }
        var oponente2 = listaHeroes.find { it.id == idHeroe2 }
        var arma2 = listaArmas.find { it.id == idArma2 }

        if (oponente1 == null || oponente2 == null) {
            print("Incomparecencia de oponente")
        } else {
            if (oponente1 is Humano && arma1 is ArmaTradicional ||
                oponente1 is Mutante && arma1 is ArmaBiologica
            ) {
                if (oponente2 is Humano && arma2 is ArmaTradicional ||
                    oponente2 is Mutante && arma2 is ArmaBiologica
                ) {
                    // nivel + (nivelPotenciaArma*nivelDanio)

                    val puntosOp1 = oponente1.nivel +
                            (oponente1.arma!!.nivelPotencia * oponente1.arma!!.nivelDanio)
                    val puntosOp2 = oponente2.nivel +
                            (oponente2.arma!!.nivelPotencia * oponente2.arma!!.nivelDanio)

                    if (puntosOp1 > puntosOp2) {
                        print("El ganador es OP1")
                        oponente1.mostrarDatos()
                    } else {
                        print("El ganador es OP2")
                        oponente2.mostrarDatos()
                    }
                }
            }
        }

    }
}