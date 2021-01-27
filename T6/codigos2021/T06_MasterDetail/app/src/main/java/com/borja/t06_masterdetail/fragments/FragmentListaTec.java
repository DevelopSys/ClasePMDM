package com.borja.t06_masterdetail.fragments;

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

import com.borja.t06_masterdetail.R;
import com.borja.t06_masterdetail.adaptadores.AdaptadorRecyclerTec;
import com.borja.t06_masterdetail.utils.Tecnologia;

import java.util.ArrayList;

public class FragmentListaTec extends Fragment {

    private RecyclerView recyclerTecnologias;
    private AdaptadorRecyclerTec adaptadorTec;
    private ArrayList<Tecnologia> listaInicial;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listaInicial = new ArrayList<>();
        listaInicial.add(new Tecnologia("Angular","FK JavaScript para aplicaciones SPA",R.drawable.angular));
        listaInicial.add(new Tecnologia("MySQL","FK JavaScript para aplicaciones SPA",R.drawable.mysql));
        listaInicial.add(new Tecnologia("Java","FK JavaScript para aplicaciones SPA",R.drawable.java));
        listaInicial.add(new Tecnologia("HTML","FK JavaScript para aplicaciones SPA",R.drawable.html));
        adaptadorTec = new AdaptadorRecyclerTec(listaInicial,context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_tec_layout,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        iniciarRecycler();
    }

    private void iniciarRecycler() {
        recyclerTecnologias.setAdapter(adaptadorTec);
        recyclerTecnologias.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        // cambio datos notify

    }

    private void instancias() {
        recyclerTecnologias = getView().findViewById(R.id.recycler_tecnologias);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
