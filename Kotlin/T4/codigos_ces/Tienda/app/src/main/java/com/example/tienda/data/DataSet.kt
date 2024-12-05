package com.example.tienda.data

import com.example.tienda.model.Producto

class DataSet {

    companion object{
        val lista: ArrayList<Producto> = arrayListOf(
            Producto("Camiseta",25.95,"ropa"),
            Producto("Pantalone",125.95,"ropa"),
            Producto("Movil",325.95,"tecnologia"),
            Producto("Tablet",525.95,"tecnologia"),
            Producto("Rastrillo",15.95,"jardin"),
            Producto("Maceta",25.95,"jardin"),
            Producto("Botella",25.95,"cocina"),
        )
    }
}