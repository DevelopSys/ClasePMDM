package com.example.agenda.model

import java.io.Serializable

class Usuario(
    var firstName: String,
    var lastName: String,
    var maidenName: String,
    var image: String,
    var id: Int
): Serializable {
}