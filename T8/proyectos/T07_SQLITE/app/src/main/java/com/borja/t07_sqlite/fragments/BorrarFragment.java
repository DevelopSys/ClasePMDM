package com.borja.t07_sqlite.fragments;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t07_sqlite.R;


public class BorrarFragment extends Fragment {


    EditText editNombre, editApellido;
    Button botonBorrar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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

            }
        });
    }
}
