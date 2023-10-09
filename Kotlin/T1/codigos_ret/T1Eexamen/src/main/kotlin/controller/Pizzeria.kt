package controller

import model.Ingrediente
import model.Pizza

class Pizzeria {

    var caja: Double = 0.0;
    lateinit var listaPizzas: ArrayList<Pizza>

    init {
        listaPizzas = ArrayList<Pizza>()
    }

    fun agregarPizza(pizza: Pizza): Unit {
        if (existePizza(pizza.id) == null) {
            listaPizzas.add(pizza)
            caja += pizza.precio;
        } else {
            println("La pizza ya existe con ese id")
        }
    }

    fun buscarPizza(idParam: Int) {
        listaPizzas.find { it.id == idParam }?.mostrarDatos()
            ?: println("El id pasado no existe")
    }

    fun mostrarCaja(){
        println("Las ganancias de las pizzas son $caja")
    }

    fun servirPizza(idParam: Int): Unit {
        if (existePizza(idParam)!=null){
            existePizza(idParam)!!.estado = true;
        }
    }

    fun listarPendientes(): Unit {
        listaPizzas.forEach {
            if (!it.estado) {
                it.mostrarDatos()
            }
        }

        //listaPizzas.filter { !it.estado }.forEach { it.mostrarDatos() }
    }

    fun existePizza(idPara: Int): Pizza? {
        return listaPizzas.find { it.id == idPara }
    }
}