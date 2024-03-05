package com.example.t7_sqlite.database

interface SchemeDB {

    companion object{
        val DB_NAME: String = "formacion.db"
        val TAB_USUARIOS: String = "usuarios"
        val COL_ID: String = "id"
        val COL_NOMBRE: String = "nombre"
        val COL_CORREO: String = "correo"
        val COL_PASS: String = "password"
        val COL_TELEFONO: String = "telefono"
        val DB_VERSION: Int = 1

    }
    // el nombre de todas las constantes de la BD -> constantes y estaticas

}