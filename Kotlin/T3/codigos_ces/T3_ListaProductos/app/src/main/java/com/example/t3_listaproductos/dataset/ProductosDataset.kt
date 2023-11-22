package com.example.t3_listaproductos.dataset

import com.example.t3_listaproductos.model.Producto

class ProductosDataset {

    companion object{
        /*todo lo que este aqui es accesible por la clase*/

        var listaProductos = ArrayList<Producto>()

        fun obtenerProducto(): Producto {

            listaProductos.add(Producto("Zapatillas","Zapatillas de deporte",
                150.0,"https://assets.adidas.com/images/w_600,f_auto,q_auto/aa53a0a800c846abb44aae8a00367e1d_9366/Zapatilla_Tensaur_Sport_Training_Lace_Blanco_GW6422_01_standard.jpg"))
            listaProductos.add(Producto("Camiseta","Camiseta de vestir",
                50.0,"https://img.macson.es/fotos/615877_1_l.jpg"))
            listaProductos.add(Producto("Pantalones","Pantalones vaqueros para salir",
                70.0,"https://i.pinimg.com/1200x/4d/7a/8f/4d7a8f512f0fdbbba31c411d35ba2bad.jpg"))
            listaProductos.add(Producto("Pulsera","Pulsera de cuero",
                20.0,""))

            return listaProductos[(0..2).random()];
        }

    }

}