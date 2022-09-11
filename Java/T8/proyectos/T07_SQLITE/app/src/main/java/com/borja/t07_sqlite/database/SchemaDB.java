package com.borja.t07_sqlite.database;

import android.provider.BaseColumns;

public interface SchemaDB extends BaseColumns {
    String NOMBRE_DB = "gestion_retamar";
    String NOMBRE_TABLA = "alumno";
    String COL_NOMBRE = "nombre";
    String COL_APELLIDO = "apellido";
    String COL_TELEFONO = "telefono";
    String COL_PASS = "pass";
}
