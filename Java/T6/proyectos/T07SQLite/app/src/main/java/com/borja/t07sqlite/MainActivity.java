package com.borja.t07sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.borja.t07sqlite.database.SQLHelper;

public class MainActivity extends AppCompatActivity {

    private Button bAgregar, bBorrar;
    private EditText eNombre, eApellido, eTelefono, eId;
    private SQLHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = helper.getWritableDatabase();
                String query = "insert into %s (%s,%s,%s) values ('%s','%s',%d)";
                db.execSQL(String.format(query,SchemaDBI.NOM_TAB,
                        SchemaDBI.NOM_COL_NOMBRE,
                        SchemaDBI.NOM_COL_APELLIDO,
                        SchemaDBI.NOM_COL_TELEFONO,
                        "Borja",
                        "Martin",
                        12345));
                db.close();
            }
        });

        bBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = helper.getWritableDatabase();
                String query = "delete from %s where %s=%d";
                db.execSQL(String.format(query,SchemaDBI.NOM_TAB,
                        SchemaDBI._ID,
                        1));
                db.close();


                // CONSULTA
                SQLiteDatabase dbR = helper.getReadableDatabase();
                Cursor cursor= dbR.rawQuery("Select * from alumno",null);
                while (cursor.moveToNext()){
                    String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                    
                }
            }
        });
    }

    private void instancias() {
        bAgregar = findViewById(R.id.boton_agregar);
        bBorrar = findViewById(R.id.boton_borrar);
        eApellido = findViewById(R.id.edit_apellido_agregar);
        eNombre = findViewById(R.id.edit_nombre_agregar);
        eId = findViewById(R.id.edit_id_agregar);
        eTelefono = findViewById(R.id.edit_telefono_agregar);
        helper = new SQLHelper(getApplicationContext(),SchemaDBI.NOM_DB,null,1);
    }
}
