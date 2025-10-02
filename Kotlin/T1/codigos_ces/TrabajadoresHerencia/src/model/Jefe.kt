package model

class Jefe(
    nombre: String, apellido: String, dni: String,
    salario: Double, var nivelResp: Int
) : Trabajador(nombre, apellido, dni, salario) {

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
}