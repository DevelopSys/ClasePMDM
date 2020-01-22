package com.borja.t06_fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06_fragments.R;

public class FragmentDinamicoDos extends Fragment {

    private TextView textView;
    private View v;
    public static String KEY_ARG_PARAM1 = "nombre";
    private String nombre;


    public static FragmentDinamicoDos newInstance(String nombre) {

        FragmentDinamicoDos fragmentDinamicoDos = new FragmentDinamicoDos();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_ARG_PARAM1, nombre);
        fragmentDinamicoDos.setArguments(bundle);
        return fragmentDinamicoDos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.getArguments() != null) {
            nombre = this.getArguments().getString(KEY_ARG_PARAM1);
        } else {
            nombre = "sin nombre";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_dinamico_dos, container, false);
        textView = v.findViewById(R.id.text_f2);
        textView.setText(nombre);
        return v;
    }
}
