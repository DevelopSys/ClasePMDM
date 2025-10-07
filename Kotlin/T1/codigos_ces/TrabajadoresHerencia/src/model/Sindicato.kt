package model

interface Sindicato {

    fun bajarSueldos(lista: ArrayList<Trabajador>): Boolean
    fun calcularBeneficios(): Double
}