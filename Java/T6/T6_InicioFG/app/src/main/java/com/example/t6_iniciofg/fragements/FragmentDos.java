package com.example.t6_iniciofg.fragements;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t6_iniciofg.R;

public class FragmentDos extends Fragment  {

    private String dato;
    private View view;
    private TextView texto;

    public static FragmentDos newInstance(String data){

        FragmentDos fragmentDos = new FragmentDos();
        Bundle bundle = new Bundle();
        bundle.putString("dato",data);
        fragmentDos.setArguments(bundle);
        return fragmentDos;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments()!=null){
            dato = this.getArguments().getString("dato");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dos_layout,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        texto = view.findViewById(R.id.etiqueta_fragment2);
        initGUI();
    }

    private void initGUI() {
        texto.setText(dato);
    }
}
