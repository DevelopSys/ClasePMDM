package com.example.filtradorestaurantes.data

import com.example.filtradorestaurantes.model.Restaurante

class DataSet {

    companion object {

        fun listaRestaurantes(): ArrayList<Restaurante> {

            val lista = ArrayList<Restaurante>();

            lista.add(
                Restaurante(
                    "Italiano1",
                    "Madrid",
                    4,
                    "Italiano",
                    9111,
                    arrayOf("Comida casera", "Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Italiano2",
                    "Alcobendas",
                    7,
                    "Italiano",
                    9222,
                    arrayOf("Comida casera", "Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Italiano3",
                    "Pozuelo",
                    9,
                    "Italiano",
                    9333,
                    arrayOf("Comida casera", "Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Italiano4",
                    "Majadahonda",
                    3,
                    "Italiano",
                    9444,
                    arrayOf("Comida casera", "Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Italiano5",
                    "Madrid",
                    9,
                    "Italiano",
                    9555,
                    arrayOf("Comida casera", "Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Mediterraneo1",
                    "Madrid",
                    6,
                    "Mediterranea",
                    9666,
                    arrayOf("Comida casera", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Mediterraneo2",
                    "Alcobendas",
                    7,
                    "Mediterranea",
                    9777,
                    arrayOf("Comida casera", "Bien de precio")
                )
            )
            lista.add(
                Restaurante(
                    "Mediterraneo3",
                    "Pozuelo",
                    5,
                    "Mediterranea",
                    9123,
                    arrayOf("Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Mediterraneo4",
                    "Majadahonda",
                    2,
                    "Mediterranea",
                    9234,
                    arrayOf("Comida casera", "Mucha cantidad de comida")
                )
            )
            lista.add(Restaurante("Chino1", "Madrid", 10, "Chino", 9345, arrayOf("Comida casera")))
            lista.add(
                Restaurante(
                    "Chino2",
                    "Alcobendas",
                    5,
                    "Chino",
                    9456,
                    arrayOf("Bien de precio")
                )
            )
            lista.add(
                Restaurante(
                    "Chino3",
                    "Pozuelo",
                    6,
                    "Chino",
                    9567,
                    arrayOf("Comida casera", "Muy bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Japones1",
                    "Alcorcón",
                    10,
                    "Japones",
                    8123,
                    arrayOf("Comida casera", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Japones2",
                    "Alcobendas",
                    5,
                    "Japones",
                    7123,
                    arrayOf("Bien de precio", "Poca cantidad de comida")
                )
            )
            lista.add(
                Restaurante(
                    "Japones3",
                    "Alcorcón",
                    6,
                    "Japones",
                    6234,
                    arrayOf("Comida casera", "Caro", "Poca cantidad de comida")
                )
            )



            return lista

        }

    }
}