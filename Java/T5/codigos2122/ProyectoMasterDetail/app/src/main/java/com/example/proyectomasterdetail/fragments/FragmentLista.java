package com.example.proyectomasterdetail.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectomasterdetail.R;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private View view;
    private ListView listView;
    private ArrayAdapter<CharSequence> adapter;
    private OnListaListener listener;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnListaListener) context;
        ArrayList listaDatos = new ArrayList();
        for (int i = 1; i < 101; i++) {
            listaDatos.add("Opcion "+i);
        }
        adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1,listaDatos);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista, container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listView = view.findViewById(R.id.lista_elementos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Toast.makeText(getContext(),
                        adapter.getItem(i).toString(),
                        Toast.LENGTH_SHORT).show();*/
                listener.onElementoListaSelected(adapter.getItem(i).toString());

            }
        });
    }

    public interface OnListaListener{
        void onElementoListaSelected(String dato);
    }
}
