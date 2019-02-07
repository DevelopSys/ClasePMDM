package com.system.develop.t4_correxamen.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.system.develop.t4_correxamen.R;
import com.system.develop.t4_correxamen.adaptadores.AdaptadorRecycer;

public class FragmentDinamico extends Fragment {

    View v;
    RecyclerView recyclerView;
    int numero;

    public static FragmentDinamico newInstance(int n) {

        Bundle args = new Bundle();
        args.putInt("asign",n);

        FragmentDinamico fragment = new FragmentDinamico();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        numero = getArguments().getInt("asign");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.dinamico_layout,container,false);

        recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setAdapter(new AdaptadorRecycer(getContext(),numero));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return v;
    }
}
