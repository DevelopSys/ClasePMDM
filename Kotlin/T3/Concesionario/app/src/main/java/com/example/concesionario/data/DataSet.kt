package com.example.concesionario.data

import androidx.core.R
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Model

class DataSet {

    companion object {


        val listModel = arrayListOf<Model>(
            Model(
                "Mondeo", 20000, 200, "mondeo description",
                "Utilitario", "", "ford"
            ),
            Model(
                "Focus", 15000, 150, "ford description",
                "Utilitario", "", "ford"
            ), Model(
                "Fiesta", 10000, 100, "fiesta description",
                "Urbano", "", "ford"
            ),
            Model(
                "A3", 35000, 200, "a3 description",
                "Utilitario", "", "audi"
            ),
            Model(
                "A5", 45000, 250, "a5 description",
                "Familiar", "", "audi"
            ), Model(
                "A6", 55000, 300, "a6 description",
                "Familar", "", "audi"
            )
        )
        val listMarca = arrayListOf<Marca>(
            Marca(-1, "Todos", listModel),
            Marca(
                com.example.concesionario.R.drawable.ford,
                "Ford", listModel.filter { it.marca == "ford" }
            ),
            Marca(
                com.example.concesionario.R.drawable.audi,
                "Audi", listModel.filter { it.marca == "audi" }
            ),
            Marca(
                com.example.concesionario.R.drawable.mercedes,
                "Mercedes", arrayListOf()
            ),
        )
    }
}