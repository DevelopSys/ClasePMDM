package com.example.concesionario.model

import java.io.Serializable

class Model(
    var name: String,
    var price: Int,
    var cv: Int,
    var description: String,
    var type: String,
    var image: String,
    var marca: String
) : Serializable