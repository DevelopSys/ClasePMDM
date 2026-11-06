package com.example.login.dataset

import com.example.login.model.Product

class DataSet {

    companion object {
        val listProduct: ArrayList<Product> = arrayListOf();

        fun initList(): Unit {
            listProduct.add(
                Product(
                    1,
                    "P1",
                    10.99,
                    "https://fotos.quecochemecompro.com/peugeot-308/41996278.jpg?size=750x400",
                    "D1"
                )
            )
            listProduct.add(
                Product(
                    2,
                    "P2",
                    20.99,
                    "I2",
                    "https://www.coches.net/blog-profesionales/wp-content/uploads/2023/03/Volkswagen-Golf.jpeg.optimal.jpeg"
                )
            )
            listProduct.add(
                Product(
                    3,
                    "P3",
                    30.99,
                    "I3",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0Hyo38Jc5Q2xhN-HXxUuH8v2sOnbzHZm0h-MEsj98FmzQoARTXU-tQQaI&s=10"
                )
            )
            listProduct.add(
                Product(
                    4,
                    "P4",
                    40.99,
                    "I4",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2RgSCnovmP0aZVgRgRgJZr2CR7aZBJ3l9SaSkjA5R5mPS46Cu2tArmfax&s=10"
                )
            )
            listProduct.add(
                Product(
                    5,
                    "P5",
                    50.99,
                    "I%",
                    "https://ataacars.com/6698-medium_default/super-deportivo-12v-coche-electrico-para-ninos-con-mando-barato.jpg"
                )
            )
        }
    }
}