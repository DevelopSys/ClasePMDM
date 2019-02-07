package com.system.develop.t4_correxamen.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.develop.t4_correxamen.R;
import com.system.develop.t4_correxamen.utils.Asignatura;

public class FragmentEstatico extends Fragment {

    View v;
    TextView textView;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.estatico_layout,container,false);
        textView = v.findViewById(R.id.textEstatico);
        imageView = v.findViewById(R.id.imagenEstatico);
        return v;
    }

    public void cambiarDatos(Asignatura a){
        textView.setText(a.getNombre());
        imageView.setImageResource(a.getImagen());
    }
}
