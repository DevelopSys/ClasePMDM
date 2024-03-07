package com.example.t7_sqlite.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.t7_sqlite.model.Usuario

class DAOUsuarios(var contexto: Context) {

    private lateinit var helper: DBHelper
    private lateinit var database: SQLiteDatabase

    init {
        helper = DBHelper(contexto, "usuarios.db", null, 1)
    }

    fun insertarAlumno(x: Usuario) {
        // insertar a la base de datos
        database = helper.writableDatabase
        database.execSQL(
            "INSERT INTO ${SchemeDB.TAB_USUARIOS}" +
                    " (${SchemeDB.COL_NOMBRE},${SchemeDB.COL_CORREO},${SchemeDB.COL_TELEFONO},${SchemeDB.COL_PASS}) " +
                    "VALUES ('${x.nombre}','${x.correo}', ${x.telefono}, '${x.pass}')"
        )
        database.close()
    }

    fun consultarDatos() {
        database = helper.readableDatabase
        val resultado: Cursor = database.rawQuery("SELECT * FROM ${SchemeDB.TAB_USUARIOS}", null)
        Log.v("datos", "Ejecutando query")
        while (resultado.moveToNext()) {
            val indice1 = resultado.getColumnIndex(SchemeDB.COL_NOMBRE) // int
            val indice2 = resultado.getColumnIndex(SchemeDB.COL_CORREO) // int
            val indice3 = resultado.getColumnIndex(SchemeDB.COL_PASS) // int
            val indice4 = resultado.getColumnIndex(SchemeDB.COL_TELEFONO) // int
            val nombre = resultado.getString(indice1) // string
            val correo = resultado.getString(indice2) // string
            val pass = resultado.getString(indice3) // string
            val telefono = resultado.getInt(indice4) // string
            Log.v("datos", "$nombre \t $correo \t $pass \t $telefono")
        }

        database.close()
    }
}