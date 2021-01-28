package com.develop.t06_fragements.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.develop.t06_fragements.R;
import com.develop.t06_fragements.adapters.AdaptadorRecyclerPersonas;
import com.develop.t06_fragements.utils.Persona;

import java.util.ArrayList;

public class FragmentRecyclerPersonas extends Fragment {

    private RecyclerView recyclerPersonas;
    private ArrayList<Persona> listaPersonas;
    private AdaptadorRecyclerPersonas adaptadorRecycler;
    private  View v;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        rellenarAdapter(context);

    }

    private void rellenarAdapter(Context context) {

        listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Borja","MArtin", R.drawable.man));
        listaPersonas.add(new Persona("Jose","Herrera", R.drawable.man));
        listaPersonas.add(new Persona("Celia","Gomez", R.drawable.woman));
        listaPersonas.add(new Persona("Roberto","De Deigo", R.drawable.man));
        listaPersonas.add(new Persona("Marta","Castillo", R.drawable.woman));
        adaptadorRecycler = new AdaptadorRecyclerPersonas(listaPersonas,getContext());
        adaptadorRecycler.notifyDataSetChanged();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_recycler_layout,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        rellenarRecycler();
    }

    private void rellenarRecycler() {
        recyclerPersonas.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerPersonas.setAdapter(adaptadorRecycler);
    }

    private void instancias() {
        recyclerPersonas = getView().findViewById(R.id.recycler_personas);
    }
}
