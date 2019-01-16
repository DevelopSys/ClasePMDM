package com.system.develop.t4_fragmentsinicio.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.system.develop.t4_fragmentsinicio.R;

public class FragmentEstaticoDos extends Fragment {

    TextView etiqueta;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estatico_dos,container,false);
        etiqueta = v.findViewById(R.id.textoFragmentDos);
        return v;
    }

    public void cambiarEtiqueta(String texto){
        etiqueta.setText(texto);
    }
}
