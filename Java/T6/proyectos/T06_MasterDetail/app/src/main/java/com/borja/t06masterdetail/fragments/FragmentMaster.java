package com.borja.t06masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06masterdetail.R;

public class FragmentMaster extends Fragment {

    private ListView listView;
    private OnFragmentMasterListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentMasterListener) context;
        } catch (ClassCastException e){

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_master, container,false);
        listView = v.findViewById(R.id.lista_master);
        final String[] opciones = {"opcion1","opcion2","opcion3","opcion4","opcion5"};
        ArrayAdapter<String> adapterListar = new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1,opciones);
        listView.setAdapter(adapterListar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listener.onFragmentMasterSelected(opciones[i]);
            }
        });

        return v;
    }


    public interface OnFragmentMasterListener{
        void onFragmentMasterSelected(String opcion);
    }
}
