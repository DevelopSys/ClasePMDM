package com.borja.t06_comunicacionfragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06_comunicacionfragments.R;

public class FragmentDos extends Fragment {

    private TextView textView;
    private String texto;

    public static FragmentDos newInstance(String texto) {


        Bundle bundle = new Bundle();
        bundle.putString("texto", texto);
        FragmentDos fragmentDos = new FragmentDos();
        fragmentDos.setArguments(bundle);
        return fragmentDos;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        texto = this.getArguments().getString("texto");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dos_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getView().findViewById(R.id.texto_fragment_dos);
        // asocio texto con textView
        textView.setText(texto);
    }
}
