package model

// final
// open
class Coche(var marca: String, var modelo: String) {

    // atributos
    var bastidor: String? = null;
    private var cv: Int = 0
        get() = field
        set(cv) {
            println("Valor modificado")
            field = cv
        }
    var cc: Int = 0;
    lateinit var propietario: Propietario;

    // constructores
    // public Coche(){}
    /*constructor(marca: String, modelo: String){
        this.marca = marca;
        this.modelo = modelo;
    }*/

    constructor(marca: String, modelo: String, bastidor: String) : this(marca, modelo) {
        this.bastidor = bastidor
    }

    // bloque ejecutado tras cualquier constructor
    /*init {
        propietario = Propietario("Borja","Martin","1234A")
    }*/
    // funciones

    var calcularVelocidad: ((Int)->Unit)? = null;

    fun aumentarVelocidad(velocidad: Int ){
        // calcularVelocidad(6) --> no se como se comporta Int -> Unit
        calcularVelocidad?.invoke(this.cc)
    }

    fun asignarPropietario(propietario: Propietario){
        this.propietario = propietario;
    }

    fun calcularParMotor (calculoPar:(Int)->Int, aceleracion: Int){
        calculoPar(aceleracion);
    }

    var mostrarDatos: () -> Unit = {
        println("Marca: $marca")
        println ("Modelo: ${modelo}")
        println ("CV: ${cv}")
        println ("CC: ${cc}")
    }

    // getter setter

    fun setCV(cv: Int) {
        this.cv = cv;
    }

    fun getCV(): Int {
        return this.cv
    }

    // toString
    override fun toString(): String {
        return super.toString()
    }
}