import model.Producto

fun main() {

    var camiseta: Producto = Producto(id = 1, precio = 14.99)
    var zapatillas = Producto(2,20.0)
    // id, precio, nombre
    var pantalones = Producto(3,30.0,"Pantalones")
    var gorra = Producto(4,20.0, descripcion = "Gorra molona")
    var cartera = Producto(5,5.0,"Cartera",
        "Cartera para guardar la pasta")

}