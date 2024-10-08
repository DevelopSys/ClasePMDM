package controller

import model.Pizza

class Pizzeria {

    lateinit var listaPizzas: ArrayList<Pizza>
    var caja: Double = 0.0;

    init {
        listaPizzas = ArrayList();
    }

    fun agregarPizza(pizza: Pizza) {
        listaPizzas.add(pizza)
    }

    fun verEstado(id: Int) {
        var pizzaEstado: Pizza? = listaPizzas.find { it.id == id }
        if (pizzaEstado!=null){
            pizzaEstado.mostrarDatos()
        } else {
            println("No hay pizza con ese id")
        }
    }

    fun servirPizza(id: Int) {
        var pizzaEstado: Pizza? = listaPizzas.find { it.id == id }
        if (pizzaEstado!=null && !pizzaEstado.servida){
            pizzaEstado.servida = true
            caja+=pizzaEstado.precio;
        }
    }

    fun verPedientes() {
        var listaPendientes = listaPizzas.filter { it.servida }
        if (listaPendientes.isNotEmpty()){
            listaPendientes.forEach { it.mostrarDatos() }
        } else {
            println("no hay pendientes")
        }
    }

}