package com.borja.correccionexamen.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.correccionexamen.R;
import com.borja.correccionexamen.utils.Persona;

public class AddFragment extends Fragment {

    private EditText editNombre, editApellido, editTelefono;
    private Button botonAdd;
    private OnElementoAddListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnElementoAddListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editNombre = getView().findViewById(R.id.edit_nombre);
        editApellido = getView().findViewById(R.id.edit_apellido);
        editTelefono = getView().findViewById(R.id.edit_telefono);
        botonAdd = getView().findViewById(R.id.button_add);
        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = new Persona(editNombre.getText().toString(),
                        editApellido.getText().toString(), Integer.valueOf(editTelefono.getText().toString()));
                listener.onElementoAdd(persona);
            }
        });
    }

    public interface OnElementoAddListener{
        void onElementoAdd(Persona persona);
    }
}
