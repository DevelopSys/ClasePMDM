package com.example.concesionario.model

import android.graphics.drawable.Drawable
import java.io.Serializable

class Marca(
    var logo: Int,
    var name: String,
    var models: List<Model>
) : Serializable{
    override fun toString(): String {
        return name
    }
}