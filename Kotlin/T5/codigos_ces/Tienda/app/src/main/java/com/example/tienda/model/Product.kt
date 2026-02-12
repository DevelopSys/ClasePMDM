package com.example.tienda.model

import java.io.Serializable

data class Product(
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val category: String? = null,
    val price: Double? = null
) : Serializable