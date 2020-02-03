package com.borja.proyectopersonas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.proyectopersonas.R;
import com.borja.proyectopersonas.adaptadores.AdaptadorRecycler;
import com.borja.proyectopersonas.utils.Persona;

import java.util.ArrayList;

public class FragmentListasPersonas extends Fragment {

    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Persona> listaPersonas;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listaPersonas = new ArrayList();
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen1));
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen2));
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen3));
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen4));
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen5));
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen6));
        listaPersonas.add(new Persona("nombre","apellido",R.drawable.imagen7));
        adaptadorRecycler = new AdaptadorRecycler(context,listaPersonas);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personas_layout, container,
                false);
        recyclerView = view.findViewById(R.id.recycler_personas);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
    }
}
