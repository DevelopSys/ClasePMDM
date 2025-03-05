package com.example.navegacion.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// clase que me permite abrir la base de datos en modo
// escritura y/o lectura
class SQLiteHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        // metodo a ejecutar si el nombre de la base de datos no existe
        // en el caso de existir la base de datos, no ejecuta nada
        p0?.execSQL("CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "password TEXT NOT NULL)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        
    }

}