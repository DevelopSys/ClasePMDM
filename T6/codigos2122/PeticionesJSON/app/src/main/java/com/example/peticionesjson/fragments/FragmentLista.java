package com.example.peticionesjson.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peticionesjson.R;
import com.example.peticionesjson.adaptadores.AdaptadorEquipos;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdaptadorEquipos adaptadorEquipos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_lista,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        asociarDatos();
        realizarPeticion();
    }

    private void realizarPeticion() {

    }

    private void asociarDatos() {
        recyclerView.setAdapter(adaptadorEquipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
    }

    private void instancias() {
        recyclerView = view.findViewById(R.id.lista_equipos);
        adaptadorEquipos  = new AdaptadorEquipos(new ArrayList(),getContext());
    }
}
