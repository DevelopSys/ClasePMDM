import model.Producto

fun main() {

    println((1..14).random())
    var gorra = Producto()
    var pantalones = Producto(2,10.0,)
    var zapatillas = Producto(3,30.0,"zapatillas")
    var cartera = Producto(4,5.0, descripcion = "esta cartera es para guardar la pasta")
    var camiseta = Producto(1,10.0,"camiseta","camiseta para salir de fiesta")
}