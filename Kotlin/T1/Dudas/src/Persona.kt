abstract class Persona() {

    var name: String? = null

    constructor(name: String): this(){
        this.name = name;
    }

    fun showData(): Unit {
        println("name = ${name}")
    }

    open fun abstractMethod(): Unit {

    }

    abstract fun abstractMethod2(): Unit
}