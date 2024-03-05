package com.example.t7_sqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DAOUsuarios(var contexto: Context) {

    private lateinit var helper:DBHelper
    private lateinit var database: SQLiteDatabase

    init {
        helper = DBHelper(contexto,"usuarios.db",null,1)
    }

    fun insertarAlumno(x: Any)  {
        // insertar a la base de datos
        database = helper.writableDatabase
        database.execSQL("INSERT INTO nombre (asd,asd,asd,asd) VALUES (${x},123)")
        //database.insert()
    }
}