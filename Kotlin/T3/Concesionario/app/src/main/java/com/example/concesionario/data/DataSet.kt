package com.example.concesionario.data

import androidx.core.R
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Model

class DataSet {

    companion object {


        val listModel = arrayListOf<Model>(
            Model(
                "Mondeo", 20000, 200, "mondeo description",
                "Utilitario", "https://a.ccdn.es/cnet/contents/media/ford/mondeo/1021058.jpg/900x505cut/", "ford"
            ),
            Model(
                "Focus", 15000, 150, "ford description",
                "Utilitario", "https://content.fastly.ccdn.es/pro/cnet/images/7c/7cbc76f7-5b81-464f-8ec4-2967cf9e255b?rule=mobileArticleBodyImage", "ford"
            ), Model(
                "Fiesta", 10000, 100, "fiesta description",
                "Urbano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0ZkQRpvNDw5KpakzaulxbjW9FfpfxQyGOhJRzXvPzvg&s=10", "ford"
            ),
            Model(
                "A3", 35000, 200, "a3 description",
                "Utilitario", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQ4mWuR79GJcPP9afZehaHi7tEnfcpNIyD0iisqizgl01gkEIhbMafMR0&s=10", "audi"
            ),
            Model(
                "A5", 45000, 250, "a5 description",
                "Familiar", "https://images.coches.com/_vn_/audi/A5/1801e342d67ad84e9a9a15e18a2c0d05.jpg?w=1920&ar=4:3", "audi"
            ), Model(
                "A6", 55000, 300, "a6 description",
                "Familar", "https://emea-dam.audi.com/adobe/assets/urn:aaid:aem:a4b0f0ac-d552-4150-aa1d-7f677d34d56e/as/A6eh_ae_2024_7686_1-S-L.jpg?auto=webp", "audi"
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