package com.borja.proyectopersonas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.borja.proyectopersonas.R;
import com.borja.proyectopersonas.utils.Persona;

public class FragmentDetalle extends Fragment {

    private ImageView imagen;
    private TextView nombre, apellido, telefono;
    static String TAG_ARG1 = "persona";
    private Persona persona;

    public static FragmentDetalle newInstace(Persona persona) {
        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG_ARG1, persona);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments() != null) {
            persona = (Persona) this.getArguments().get(TAG_ARG1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmente_detalle_layout, container, false);
        imagen = v.findViewById(R.id.imagen_detalle);
        nombre = v.findViewById(R.id.texto_detalle_nombre);
        apellido = v.findViewById(R.id.texto_detalle_apellido);
        telefono = v.findViewById(R.id.texto_detalle_numero);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imagen.setImageResource(persona.getImagen());
        nombre.setText(persona.getNombre());
        apellido.setText(persona.getApellido());
    }
}
