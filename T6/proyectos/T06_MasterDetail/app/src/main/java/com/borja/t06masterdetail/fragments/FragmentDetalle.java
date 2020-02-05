package com.borja.t06masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06masterdetail.R;

public class FragmentDetalle extends Fragment {

    final static String KEY_PARM1 = "argumento_uno";
    private String dato;
    private TextView texto;

    public static FragmentDetalle newInstance(String dato) {
        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PARM1, dato);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.getArguments() != null) {
            this.dato = this.getArguments().getString(KEY_PARM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detalle,
                container, false);
        texto = v.findViewById(R.id.texto_detalle);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        texto.setText(dato);
    }
}
