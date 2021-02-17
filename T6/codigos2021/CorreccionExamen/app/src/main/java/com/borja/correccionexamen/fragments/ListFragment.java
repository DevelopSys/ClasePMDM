package com.borja.correccionexamen.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.correccionexamen.R;
import com.borja.correccionexamen.adaptadores.AdapterRecycler;
import com.borja.correccionexamen.utils.Persona;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterRecycler adapterRecycler;

    public void addPersona(Persona persona){
        adapterRecycler.addPersona(persona);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        adapterRecycler = new AdapterRecycler(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getView().findViewById(R.id.recycler_elementos);
        recyclerView.setAdapter(adapterRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }
}
