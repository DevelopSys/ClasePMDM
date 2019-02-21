package com.system.develop.t5_bd.basedatos;

import android.provider.BaseColumns;

public interface DatosBD extends BaseColumns {

    String DB_NAME= "bdalumnos";
    String TAB_ALU= "alumnos";
    String TAB_ALU_COL_NOM= "nombre";
    String TAB_ALU_COL_CORR= "correo";
    String TAB_ALU_COL_APE= "apellidos";
}
