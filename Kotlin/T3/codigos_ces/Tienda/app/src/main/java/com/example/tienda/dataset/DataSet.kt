package com.example.tienda.dataset

import android.util.Log
import com.example.tienda.model.Producto

class DataSet {

    companion object {
        var lista: ArrayList<Producto> = arrayListOf(
            Producto(
                1,
                "Armario",
                112,
                10.0,
                "descripcion1",
                "muebles",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbycGI7iVvr1aWwCJvaf3NfohBYYfQNgypeg&s"
            ),
            Producto(
                2,
                "Puertas",
                212,
                20.0,
                "descripcion2",
                "muebles",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9v-wVogGPmReiWqCjWs7RmJ0BfGhxSxKcYA&s"
            ),
            Producto(
                2,
                "Movil",
                312,
                30.0,
                "descripcion3",
                "tecnologia",
                "https://imagenes.elpais.com/resizer/v2/XERZXBX2UZDFPNL45DUWRGBAYM.jpg?auth=62715280f8a5ee79daf7f09f83c4f503a3c6cdc818a0db36a7655a09b9e7c319&width=1960&height=1103&smart=true"
            ),
            Producto(
                2,
                "Portail",
                412,
                40.0,
                "descripcion4",
                "tecnologia",
                "https://images.unsplash.com/photo-1618424181497-157f25b6ddd5?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8bGFwdG9wJTIwY29tcHV0ZXJ8ZW58MHx8MHx8fDA%3D"
            ),
            Producto(
                2,
                "Pantalones",
                512,
                50.0,
                "descripcion5",
                "ropa",
                "https://media.vogue.es/photos/5cc7367f92f813c7264e4eb6/master/w_1600%2Cc_limit/pantalones_vaqueros_pitillo_mango_basicos_armario_2019_7371.jpg"
            ),
            Producto(
                2,
                "Camiseta",
                612,
                60.0,
                "descripcion6",
                "ropa",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIQ8hEv2cIrl_09DYuj8p-fQopD1dpNKy-tQ&s"
            ),
        )

        var listaCarrito: ArrayList<Producto> = arrayListOf()

        fun addProducto(x: Producto) {
            listaCarrito.add(x)
            Log.v("carrito", listaCarrito.size.toString())
        }

        fun getListaFiltrada(categoria: String): ArrayList<Producto> {
            if (categoria == "todas") {
                return lista
            } else {
                return lista.filter { it.categoria.equals(categoria, true) }
                        as ArrayList<Producto>
            }

        }


    }

}