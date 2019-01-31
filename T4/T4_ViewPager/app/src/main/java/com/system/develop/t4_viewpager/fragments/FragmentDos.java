package com.system.develop.t4_viewpager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.system.develop.t4_viewpager.R;

public class FragmentDos extends Fragment{

    View v;
    TextView textView;

    public static FragmentDos newInstance(String asd) {
        
        Bundle args = new Bundle();
        
        FragmentDos fragment = new FragmentDos();
        fragment.setArguments(args);
        return fragment;
    }

    public void cambiarDatos(String s){
        textView.setText(s);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fracment_dos_layout,container,false);
        textView = v.findViewById(R.id.comunicacionf1);
        return v;
    }
}
