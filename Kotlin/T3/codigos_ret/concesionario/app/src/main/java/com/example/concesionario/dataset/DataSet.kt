package com.example.concesionario.dataset

import android.view.Display
import com.example.concesionario.model.Coche
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class DataSet {

    companion object {
        fun getListaModelos(marca: Marca): ArrayList<Modelo> {
            val listaModelos: ArrayList<Modelo> = arrayListOf()

            when (marca.nombre) {
                "Ford" -> {
                    listaModelos.add(Modelo(marca, "Focus"))
                    listaModelos.add(Modelo(marca, "Fiesta"))
                    listaModelos.add(Modelo(marca, "Mondeo"))
                    listaModelos.add(Modelo(marca, "Kuga"))
                }

                "Mercedes" -> {
                    listaModelos.add(Modelo(marca, "Clase A"))
                    listaModelos.add(Modelo(marca, "Clase B"))
                    listaModelos.add(Modelo(marca, "Clase C"))
                    listaModelos.add(Modelo(marca, "Clase S"))
                    listaModelos.add(Modelo(marca, "Clase E"))
                }

                "Seat" -> {
                    listaModelos.add(Modelo(marca, "Ibiza"))
                    listaModelos.add(Modelo(marca, "Arona"))
                    listaModelos.add(Modelo(marca, "Panda"))
                }

                "Audi" -> {
                    listaModelos.add(Modelo(marca, "E-Tron"))
                    listaModelos.add(Modelo(marca, "A3"))
                    listaModelos.add(Modelo(marca, "A4"))
                    listaModelos.add(Modelo(marca, "A6"))
                }
            }

            return listaModelos
        }

        fun getModelos(modelo: Modelo): ArrayList<Coche> {
            val listaFiltrada: ArrayList<Coche> = arrayListOf()
            when (modelo.modelo) {
                "Fiesta" -> {
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Fiesta",
                            20000,
                            150,
                            "https://fotos.quecochemecompro.com/ford-fiesta/ford-fiesta-azul-dinamico-movimiento.jpg?size=750x400",
                            "Estos son los detalles del fiesta"
                        ),
                    )
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Fiesta",
                            10000,
                            100,
                            "https://www.shutterstock.com/image-photo/stony-stratforduk-june-2nd-2024-260nw-2471679637.jpg",
                            "Estos son los detalles del fiesta normal"
                        ),
                    )
                }

                "Focus" -> {
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Focus",
                            40000,
                            200,
                            "https://www.ford.es/content/dam/guxeu/rhd/central/cars/2021-focus/dse/column-cards/ford-focus-eu-Column_Card_Focus-Active-X-3x2-1000x667-chrome-blue-front-view.jpg",
                            "Estos son los detalles del focus GT"
                        ),
                    )
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Fucus",
                            25000,
                            120,
                            "https://fotos.quecochemecompro.com/ford-focus/ford-focus-dinamismo-urbano.jpg?size=750x400",
                            "Estos son los detalles del focus familiar"
                        ),
                    )
                }

                "Clase A" -> {
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Clase A",
                            40000,
                            250,
                            "https://fotos.quecochemecompro.com/mercedes-clase-a/mercedes-clase-a-dinamismo-puro.jpg?size=750x400",
                            "Estos son los detalles del ClaseA AMG"
                        ),
                    )
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Clase A",
                            20000,
                            150,
                            "https://i.blogs.es/deb432/mercedes-benz-a200-prueba-motorpasion-1portada/1366_2000.jpg",
                            "Estos son los detalles del ClaseA"
                        ),
                    )
                }

                "Clase B" -> {
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Clase B",
                            50000,
                            250,
                            "https://images.coches.com/_vn_/mercedes/Clase-B/04d52fd11131481fa177f1c4bfd0bf1e.jpg?w=1920&ar=4:3",
                            "Estos son los detalles del ClaseB AMG"
                        ),
                    )
                    listaFiltrada.add(
                        Coche(
                            modelo.marca,
                            "Clase B",
                            30000,
                            170,
                            "https://fotos.inventario.pro/coche/1838/2451494/8725a37c-7680-44eb-aa02-19872d5ef868/40543ad341c7ad9b85737cf1254c2d0f.jpg",
                            "Estos son los detalles del ClaseB"
                        ),
                    )
                }
            }
            return listaFiltrada
        }
    }
}