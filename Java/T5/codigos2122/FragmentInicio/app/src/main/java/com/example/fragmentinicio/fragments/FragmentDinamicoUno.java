package com.example.fragmentinicio.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentinicio.R;
import com.example.fragmentinicio.utils.Usuario;

public class FragmentDinamicoUno extends Fragment {

    private Button botonComunicar;
    private EditText editNombre, editApellido, editEdad;
    private View view;
    private OnFragmentUnoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentUnoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dinamico_uno_layout,
                container,false);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        // instancia
        editNombre = view.findViewById(R.id.edit_nombre);
        editApellido = view.findViewById(R.id.edit_apellido);
        editEdad = view.findViewById(R.id.edit_edad);
        botonComunicar = view.findViewById(R.id.boton_comunicar);

        botonComunicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editNombre.getText().toString();
                String apellido = editApellido.getText().toString();
                int edad = Integer.parseInt(editEdad.getText().toString());
                //Log.v("prueba",nombre);
                // ejecuto comunicacion
                listener.onPersonaSelected(new Usuario(nombre,apellido,edad));
            }
        });
    }

    public interface OnFragmentUnoListener{
        void onPersonaSelected(Usuario usuario);
    }
}
