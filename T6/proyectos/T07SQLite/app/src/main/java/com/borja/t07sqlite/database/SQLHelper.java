package com.borja.t07sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.borja.t07sqlite.SchemaDBI;

public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL();
        String query = "CREATE TABLE " + SchemaDBI.NOM_TAB + " (" +
                SchemaDBI._ID + " INTEGER PRIMARY KEY," +
                SchemaDBI.NOM_COL_NOMBRE + " TEXT," +
                SchemaDBI.NOM_COL_APELLIDO + " TEXT,"+
                SchemaDBI.NOM_COL_TELEFONO + " INTEGER)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
