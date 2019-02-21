package com.system.develop.t5_bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.system.develop.t5_bd.basedatos.DatosBD;
import com.system.develop.t5_bd.basedatos.HelperDB;

import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    HelperDB helperDB;
    SQLiteDatabase baseDatos;
    Button botonCrear, botonBorrar, botonActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        seleccion();
    }

    private void seleccion() {
        baseDatos = helperDB.getReadableDatabase();
        String query = "SELECT * FROM %s";
        Cursor c = baseDatos.rawQuery(String.format(query,DatosBD.TAB_ALU),null);
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex(DatosBD._ID));
            String nombre = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_NOM));
            String apellido = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_APE));
            String correo = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_CORR));
            Usuarios u = new Usuarios(id,nombre,apellido,correo);
            Log.v("bd",String.valueOf(u.getId())+" "+u.getNombre());
        }
        baseDatos.close();
    }

    private void acciones() {
        botonCrear.setOnClickListener(this);
        botonBorrar.setOnClickListener(this);
        botonActualizar.setOnClickListener(this);
    }

    private void instancias() {
        helperDB = new HelperDB(getApplicationContext(), DatosBD.DB_NAME, null, 2);
        botonCrear = findViewById(R.id.bInsertar);
        botonBorrar = findViewById(R.id.bBorrar);
        botonActualizar = findViewById(R.id.bActualizar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bInsertar:

                baseDatos = helperDB.getWritableDatabase();
                /*String query = "INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')";
                baseDatos.execSQL(String.format(query
                        , DatosBD.TAB_ALU
                        , DatosBD.TAB_ALU_COL_NOM
                        , DatosBD.TAB_ALU_COL_APE
                        , DatosBD.TAB_ALU_COL_CORR
                        , "NombreSQL"
                        , "ApellidoSQL"
                        , "CorreoSQL"));*/

                /*ContentValues contentInsertar = new ContentValues();
                contentInsertar.put(DatosBD.TAB_ALU_COL_CORR, "CorreoCV");
                contentInsertar.put(DatosBD.TAB_ALU_COL_NOM, "NombreCV");
                contentInsertar.put(DatosBD.TAB_ALU_COL_APE, "ApellidoCV");
                baseDatos.insert(DatosBD.TAB_ALU, null,contentInsertar);
                baseDatos.close();*/

                break;

            case R.id.bBorrar:
                baseDatos = helperDB.getWritableDatabase();
                /*String query = "DELETE FROM %s WHERE %s='%s'";
                baseDatos.execSQL(String.format(query
                , DatosBD.TAB_ALU
                , DatosBD.TAB_ALU_COL_NOM
                , "NombreCV"));*/

                /*
                String whereQuery = "%s=? AND %s=?";
                baseDatos.delete(DatosBD.TAB_ALU
                        , String.format(whereQuery, DatosBD.TAB_ALU_COL_NOM, DatosBD.TAB_ALU_COL_APE)
                        , new String[]{"NombreCv","Apellido"} );*/

                baseDatos.close();
                break;
            case R.id.bActualizar:
                baseDatos = helperDB.getWritableDatabase();
                /*String query = "UPDATE %s SET %s='%s' WHERE %s='%s'";
                baseDatos.execSQL(String.format(query,DatosBD.TAB_ALU,
                        DatosBD.TAB_ALU_COL_NOM
                        , "NombreNuevo"
                        , DatosBD.TAB_ALU_COL_NOM
                        , "NombreSQL"));*/

                ContentValues contentActualizar = new ContentValues();
                contentActualizar.put(DatosBD.TAB_ALU_COL_NOM,"NombreContent");
                baseDatos.update(DatosBD.TAB_ALU,contentActualizar,"nombre=?",new String[]{"NombreNuevo"});
                baseDatos.close();

                break;
        }


    }
}
