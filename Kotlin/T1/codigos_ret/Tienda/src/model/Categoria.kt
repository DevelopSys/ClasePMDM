package model

enum class Categoria(var nombre: String, var iva: Double) {
    Mueble("Muebles", 0.1),
    Tecnologia("Tecnologia", 0.2),
    Ropa("Ropa", 0.15),
    Generica("Sin categoria", 0.05)
}