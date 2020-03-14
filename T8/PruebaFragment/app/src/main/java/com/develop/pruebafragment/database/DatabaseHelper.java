package com.develop.pruebafragment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String queryCreate = "CREATE TABLE %s (" +
            "    %s INTEGER PRIMARY KEY, " +
            "    %s TEXT NOT NULL, " +
            "    %s TEXT NOT NULL, " +
            "    %s INTEGER NOT NULL UNIQUE, " +
            "    %s TEXT NOT NULL UNIQUE" +
            ");";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SchemaDB.TABLE_AL + " (" +
                    SchemaDB._ID + " INTEGER PRIMARY KEY," +
                    SchemaDB.COL_NOM + " TEXT," +
                    SchemaDB.COL_APE + " TEXT," +
                    SchemaDB.COL_PASS + " TEXT," +
                    SchemaDB.COL_TEL + " INTEGER)";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.v("db", "creada");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
