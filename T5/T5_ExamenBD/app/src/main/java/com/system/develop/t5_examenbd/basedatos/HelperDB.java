package com.system.develop.t5_examenbd.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {


    public HelperDB(@Nullable @android.support.annotation.Nullable Context context, @Nullable @android.support.annotation.Nullable String name, @Nullable @android.support.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "%s TEXT NOT NULL ," +
                "%s TEXT NOT NULL ," +
                "%s TEXT NOT NULL)";

        db.execSQL(String.format(query, DatosBD.TAB_ALU
                , DatosBD._ID
                , DatosBD.TAB_ALU_COL_NOM
                , DatosBD.TAB_ALU_COL_AP
                , DatosBD.TAB_ALU_COL_CICL));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
