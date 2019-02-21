package com.system.develop.t5_bd.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {


    public HelperDB(@androidx.annotation.Nullable @Nullable Context context,
                    @androidx.annotation.Nullable @Nullable String name,
                    @androidx.annotation.Nullable @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // db.execSQL();
        // ejecutado la primera vez que se llama al objeto heper
        db.execSQL("CREATE TABLE "+DatosBD.TAB_ALU+" ("
                +DatosBD._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +DatosBD.TAB_ALU_COL_NOM +" TEXT NOT NULL,"
                +DatosBD.TAB_ALU_COL_APE+" TEXT NOT NULL,"
                +DatosBD.TAB_ALU_COL_CORR+" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
