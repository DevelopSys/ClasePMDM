package com.example.masterdetail.fragments;

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

import com.example.masterdetail.R;

import java.util.ArrayList;

public class FragmentMaster extends Fragment {


    private View view;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList datos;
    private OnElementoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnElementoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_master,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listView = view.findViewById(R.id.lista_master);
        datos = new ArrayList();
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, datos);
        for (int i = 1; i < 100; i++) {
            datos.add("Opcion "+i);
            adapter.notifyDataSetChanged();
        }
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getContext(), listView.getAdapter().getItem(i).toString(), Toast.LENGTH_SHORT).show();
                listener.onElementoSelected((String) listView.getItemAtPosition(i));
            }
        });
    }

    public interface OnElementoListener{
        void onElementoSelected(String elemento);
    }
}
