package com.system.develop.t5_examenbd.basedatos;

import android.provider.BaseColumns;

public interface DatosBD extends BaseColumns {

    String TAB_ALU = "alumnos";
    String DB_NAME = "bdalumnos";
    String TAB_ALU_COL_NOM = "nombre";
    String TAB_ALU_COL_AP = "apellido";
    String TAB_ALU_COL_CICL = "ciclo";
}
