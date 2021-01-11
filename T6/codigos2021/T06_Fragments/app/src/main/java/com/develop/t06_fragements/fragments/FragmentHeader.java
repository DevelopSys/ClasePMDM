package com.develop.t06_fragements.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.develop.t06_fragements.R;

public class FragmentHeader extends Fragment {

    private Button botonCabecera;
    private View view;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_header,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    public void instancias(){
        botonCabecera = view.findViewById(R.id.button_cabecera);
        //botonCabecera = getView().findViewById(R.id.button_cabecera);
    }

    public void acciones(){
        botonCabecera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "header puslado", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "header puslado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
