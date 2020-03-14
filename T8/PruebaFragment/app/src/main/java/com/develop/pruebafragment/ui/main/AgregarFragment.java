package com.develop.pruebafragment.ui.main;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.develop.pruebafragment.R;
import com.develop.pruebafragment.database.DatabaseHelper;
import com.develop.pruebafragment.database.SchemaDB;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {


    private DatabaseHelper helper;
    private EditText editNombre, editApellido, editTelefono, editPass;
    private Button botonLimpiar, botonAgregar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        helper = new DatabaseHelper(getContext(),
                SchemaDB.NAME_DB,null,1);
    }

    public AgregarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agregar, container, false);
        editNombre = v.findViewById(R.id.edit_nombre_agregar);
        editApellido = v.findViewById(R.id.edit_apellido_agregar);
        editPass = v.findViewById(R.id.edit_pass_agregar);
        editTelefono = v.findViewById(R.id.edit_telefono_agregar);
        botonAgregar = v.findViewById(R.id.boton_agregar);
        botonLimpiar = v.findViewById(R.id.boton_agregar_borrar);

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*QUERY*/
                String nombre=editNombre.getText().toString();
                String apellido=editApellido.getText().toString();
                int telefono= Integer.parseInt(editTelefono.getText().toString());
                String pass=editPass.getText().toString();
                SQLiteDatabase database = helper.getWritableDatabase();
                String query = "INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s',%d)";
                String queryBorrar = "DELETE FROM %s WHERE %s = '%s";
                String queryActualizar = "UPDATE FROM %s WHERE %s = '%s' SET %s = '%s' ";
                database.execSQL(String.format(query,SchemaDB.TABLE_AL,SchemaDB.COL_NOM,
                        SchemaDB.COL_APE,SchemaDB.COL_PASS,SchemaDB.COL_TEL,
                        nombre,apellido,pass,telefono));
                database.close();
                Log.v("db","pulsado");

                /*ContentValue*/

                SQLiteDatabase databaseContent = helper.getWritableDatabase();
                ContentValues contentAgregar = new ContentValues();
                contentAgregar.put(SchemaDB.COL_NOM,editNombre.getText().toString());
                contentAgregar.put(SchemaDB.COL_APE,editApellido.getText().toString());
                contentAgregar.put(SchemaDB.COL_PASS,editPass.getText().toString());
                contentAgregar.put(SchemaDB.COL_TEL,Integer.valueOf(editTelefono.getText().toString()));
                databaseContent.insert(SchemaDB.TABLE_AL,null,contentAgregar);
                databaseContent.delete(SchemaDB.TABLE_AL, SchemaDB.COL_NOM+"=?",new String[]{"Nombre1"});
                ContentValues actualizaUsuario = new ContentValues();
                actualizaUsuario.put(SchemaDB.COL_NOM,"NombreNuevo");
                databaseContent.update(SchemaDB.TABLE_AL,actualizaUsuario,
                        SchemaDB.COL_NOM+"=?",new String[]{"Nombre1"});
                databaseContent.close();



            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase dbRead = helper.getReadableDatabase();
                Cursor cursor = dbRead.rawQuery("Select * from alumno", null);
                Log.v("db", String.valueOf(cursor.getCount()));
                dbRead.close();
            }
        });
    }
}
