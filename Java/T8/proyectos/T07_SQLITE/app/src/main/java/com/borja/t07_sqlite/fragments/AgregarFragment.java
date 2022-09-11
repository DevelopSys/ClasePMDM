package com.borja.t07_sqlite.fragments;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t07_sqlite.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {


    private EditText editNombre, editApellido, editTelefono, editPass;
    private Button botonLimpiar, botonAgregar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SQLiteDatabase baseDatos = null;

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



            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
