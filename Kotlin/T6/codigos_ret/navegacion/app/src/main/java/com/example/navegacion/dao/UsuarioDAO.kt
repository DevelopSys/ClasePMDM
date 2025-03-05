package com.example.navegacion.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.navegacion.database.SQLiteHelper
import com.example.navegacion.model.Usuario

class UsuarioDAO(val context: Context) {

    private lateinit var database: SQLiteDatabase

    // insert, update, delete
    fun insertarUsuario(usuario: Usuario){
        // context, name, factory, version
        val helper: SQLiteOpenHelper = SQLiteHelper(context,
            "usuario.db",null, 1)
        database = helper.writableDatabase
        // utilizo un SQL
        // database.execSQL()
        val contentValueInsert = ContentValues()
        contentValueInsert.put("name",usuario.correo)
        contentValueInsert.put("password",usuario.pass)
        database.insert("users",null,contentValueInsert)
    }

    // select
}