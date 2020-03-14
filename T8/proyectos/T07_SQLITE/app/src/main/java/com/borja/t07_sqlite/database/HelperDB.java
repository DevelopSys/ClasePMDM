package com.borja.t07_sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {

    private final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SchemaDB.NOMBRE_TABLA + " (" +
                    SchemaDB._ID + " INTEGER PRIMARY KEY," +
                    SchemaDB.COL_NOMBRE + " TEXT," +
                    SchemaDB.COL_APELLIDO + " TEXT," +
                    SchemaDB.COL_PASS + " TEXT," +
                    SchemaDB.COL_TELEFONO + " INTEGER)";
    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
