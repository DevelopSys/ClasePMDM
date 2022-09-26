package model

class Asalariado(nombre: String, apellido: String, edad: Int, var correo: String) : Persona(nombre, apellido, edad) {

    private var NSS: Int = 0;
    private var salario: Int? = null;
    private var pagas: Int = 12;

    constructor(nombre: String, apellido: String, edad: Int, correo: String, nss: Int, salario: Int) : this(
        nombre,
        apellido,
        edad,
        correo
    ) {
        this.NSS = nss;
        this.salario = salario;

    }

    // crear el método que me permite ver los datos del salario del usuario
    // bruto anual, neto anual
    // neto mensual
    // necesito que el usuario me diga el % de retencion que quiere aplicar

    fun calculoSalarios(retenciones: Int) {
        var retencionesCalculadas: Double =
            (this.salario!! * (retenciones/100)).toDouble();
        println("El salario neto anual es ${this.salario!! - retencionesCalculadas}")
        println("El salario neto mensual es ${(this.salario!! - retencionesCalculadas)/this.pagas}")
    //println("Ejecicion ${salario?.plus(20)}")
        //println("Ejecicion ${salario!! * 20}")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("NSS: $NSS")
        println("Correo: $correo")
        println("Salario: $salario")
    }

    fun getNSS(): Int {

        return this.NSS;
    }

    fun setNSS(nss: Int) {
        this.NSS = nss
    }

    fun getSalario(): Int {
        return this.salario!!;
    }

    fun setSalario(salario: Int) {
        this.salario = salario
    }


}