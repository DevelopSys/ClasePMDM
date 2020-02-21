package com.borja.t07sqlite;

import android.provider.BaseColumns;

public interface SchemaDBI extends BaseColumns {
    String NOM_DB = "ces_gestion";
    String NOM_TAB = "alumno";
    String NOM_COL_NOMBRE = "nombre";
    String NOM_COL_APELLIDO = "apellido";
    String NOM_COL_TELEFONO = "telefono";
    String NOM_COL_ID = "id";
}
