package com.develop.pruebafragment.ui.main;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.develop.pruebafragment.R;
import com.develop.pruebafragment.database.DatabaseHelper;
import com.develop.pruebafragment.database.SchemaDB;

public class BorrarFragment extends Fragment {


    EditText editNombre, editApellido;
    Button botonBorrar;
    private DatabaseHelper helper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        helper = new DatabaseHelper(getContext(), SchemaDB.NAME_DB, null, 1);
    }

    public BorrarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_borrar, container, false);
        editNombre = v.findViewById(R.id.edit_nombre_borrar);
        editApellido = v.findViewById(R.id.edit_apellido_borrar);
        botonBorrar = v.findViewById(R.id.boton_borrar);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database = helper.getWritableDatabase();
                String queryNombre = "Delete from %s where %s='%s'";
                String queryApellido = "Delete from %s where %s='%s'";
                String queryNomApellido = "Delete from %s where %s='%s' and %s='%s'";
                String queryDef = null;
                if (editApellido.getText().toString().isEmpty() && editNombre.getText().toString().isEmpty()) {
                    queryDef = String.format(queryNomApellido,SchemaDB.TABLE_AL,SchemaDB.COL_NOM,editNombre.getText().toString(),SchemaDB.COL_APE, editApellido.getText().toString());
                } else if (editApellido.getText().toString().isEmpty() && !editNombre.getText().toString().isEmpty()) {
                    queryDef = String.format(queryNombre,SchemaDB.TABLE_AL,SchemaDB.COL_NOM, editNombre.getText().toString());
                }
                if (!editApellido.getText().toString().isEmpty() && editNombre.getText().toString().isEmpty()) {
                    queryDef = String.format(queryApellido,SchemaDB.TABLE_AL,SchemaDB.COL_APE,editApellido.getText().toString());
                }
                database.execSQL(queryDef);
            }
        });
    }
}
