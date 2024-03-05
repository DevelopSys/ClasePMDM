package com.example.t7_sqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    // esta clase permite llegar a la base de datos
    override fun onCreate(db: SQLiteDatabase?) {
        // ejecutado cuando la base de datos no existe
        db?.execSQL("")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // ejecugtado cuando la version indcada es menor que la actual
        db?.execSQL("")
    }
}