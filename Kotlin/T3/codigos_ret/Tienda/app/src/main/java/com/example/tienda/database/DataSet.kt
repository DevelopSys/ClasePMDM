package com.example.tienda.database

import com.example.tienda.model.Producto

class DataSet {

    companion object
    {
        var listaProductos: ArrayList<Producto> = arrayListOf(
            Producto("Camiseta vaquera","ropa",30.50,"Camiseta vaquera muy calentita"),
            Producto("Pantalon vaquera","ropa",100.50,"Pantalon moderlo"),
            Producto("Telefono movil","tecnologia",330.50,"Telefono de ultima generacion"),
            Producto("Mesa comedor","mueble",130.50,"Mueble para la cocina")
        )
    }

}