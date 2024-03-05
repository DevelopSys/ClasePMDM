package com.example.t7_sqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(
    context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    // esta clase permite llegar a la base de datos
    override fun onCreate(db: SQLiteDatabase?) {
        // ejecutado cuando la base de datos no existe
        db?.execSQL("CREATE TABLE ${SchemeDB.TAB_USUARIOS}" +
                "( ${SchemeDB.COL_ID} INTEGER  PRIMARY KEY AUTOINCREMENT" +
                ", ${SchemeDB.COL_NOMBRE} TEXT NOT NULL" +
                ", ${SchemeDB.COL_CORREO} TEXT NOT NULL" +
                ", ${SchemeDB.COL_PASS} TEXT NOT NULL" +
                ", ${SchemeDB.COL_TELEFONO} INTEGER NOT NULL)");

        Log.v("database","Base de datos creada correctamente")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // ejecugtado cuando la version indcada es menor que la actual
        db?.execSQL("")
    }
}