package model

class Jefe(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Double,
    var benificos: Double,
    var acciones: Int
) : Trabajador(nombre, apellido, dni, sueldo) {
    override fun calcularSalario() {
        var sueldoMes = sueldo!! / 12
        println("Tu sueldo mensual es de $sueldoMes")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Beneficios: $benificos")
        println("Acciones: $acciones")
    }

    // TODO
    fun despedir(dni: String, lista: ArrayList<Trabajador>) {
        val trabajadorDespedir: Trabajador? = lista.find {
            if ((it::class.java.simpleName.equals("Autonomo")
                        ||
                        it::class.java.simpleName.equals("Asalariado"))
                && it.dni.equals(dni)
            ) {
                return@find true;
            }
            return@find false;
        }
        if (trabajadorDespedir != null) {
            lista.remove(trabajadorDespedir)
        }
    }
}