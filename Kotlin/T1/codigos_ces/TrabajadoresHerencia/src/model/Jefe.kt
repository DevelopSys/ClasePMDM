package model

class Jefe(
    nombre: String, apellido: String, dni: String,
    salario: Double, var nivelResp: Int
) : Trabajador(nombre, apellido, dni, salario), Sindicato {

    fun incrementarResponsabilidad(){
        if (nivelResp<5)
            nivelResp++
    }

    fun decrementarResponsabilidad(){
        if (nivelResp>0)
            nivelResp--
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nivelResp = ${nivelResp}")
    }
    override fun calcularSalarioNeto(): Double {
        if (nivelResp>=3){
            salario *= 1.03
        } else {
            salario *= 0.97
        }
        return salario
    }

    override fun bajarSueldos(lista: ArrayList<Trabajador>): Boolean {

        lista.forEach {
            if (it !is Jefe){
                it.salario *= 0.90
            }
        }

        return true
    }


    override fun calcularBeneficios(): Double {
        println("Como jefe, vas a calcular el beneficio de la empresa")
        return 0.0
    }
}