package com.example.navegacion.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.navegacion.database.SQLiteHelper
import com.example.navegacion.model.Usuario

class UsuarioDAO(val context: Context) {

    private lateinit var database: SQLiteDatabase

    // insert, update, delete
    fun insertarUsuario(usuario: Usuario){
        // context, name, factory, version
        val helper: SQLiteOpenHelper = SQLiteHelper(context,
            "usuario_prueba.db",null, 1)
        database = helper.writableDatabase
        // utilizo un SQL
        // database.execSQL()
        val contentValueInsert = ContentValues()
        contentValueInsert.put("name",usuario.correo)
        contentValueInsert.put("password",usuario.pass)
        database.insert("users",null,contentValueInsert)
    }
    // select

    @SuppressLint("Range")
    fun getAllUser(){
        val helper: SQLiteOpenHelper = SQLiteHelper(context,
            "usuario.db",null, 1)
        database = helper.readableDatabase
        // SQL -> Cursor
        val cursor: Cursor = database
            .query("users", arrayOf("name","password"),null,null,null,null,null)

        while (cursor.moveToNext()){
            val nombre: String = cursor.getString(cursor.getColumnIndex("name"))
            val passwd: String = cursor.getString(cursor.getColumnIndex("password"))
            Log.v("datos","Nombre: $nombre Pass: $passwd")
        }

        cursor.close()
    }

    @SuppressLint("Range")
    fun getAllUserPrueba(): Boolean{
        val helper: SQLiteOpenHelper = SQLiteHelper(context,
            "usuario_prueba.db",null, 1)
        database = helper.readableDatabase
        // SQL -> Cursor
        val cursor: Cursor = database
            .query("users", arrayOf("name","password"),null,null,null,null,null)

        return cursor.moveToNext()
    }
}