class Coche {

    // variables
    var marca: String
    var modelo: String
    var cv: Int;
    var bastidor: String? = null;

    // constructores
    // public Coche(){}
    constructor(marca: String, modelo: String, cv: Int) {
        this.marca = marca;
        this.modelo = modelo
        this.cv = cv;
    }

    constructor(marca: String, modelo: String, cv: Int, bastidor: String) {
        this.marca = marca;
        this.modelo = modelo
        this.cv = cv;
        this.bastidor = bastidor;
    }
    // metodos

    // crear metodos que permitan al coche aumentar la velocidad,
    // reducir la velocidad y parar el coche

    // getter - setter
    // tal cual los sabemos
    // toString

}