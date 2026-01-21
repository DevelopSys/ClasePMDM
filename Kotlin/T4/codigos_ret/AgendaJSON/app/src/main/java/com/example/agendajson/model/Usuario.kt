package com.example.agendajson.model

import java.io.Serializable

data class Usuario(
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val maidenName: String? = null,
    val age: Long? = null,
    val gender: String? = null,
    val email: String? = null,
    val image: String? = null
): Serializable