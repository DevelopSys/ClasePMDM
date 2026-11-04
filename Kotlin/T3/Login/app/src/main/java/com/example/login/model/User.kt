package com.example.login.model

import java.io.Serializable


class User(
    var name: String,
    var surname: String,
    var mail: String,
    var pass: String,
    var profile: Int
): Serializable