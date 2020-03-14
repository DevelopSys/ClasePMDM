package com.develop.pruebafragment.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.develop.pruebafragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActualizarFragment extends Fragment {


    public ActualizarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_actualizar, container, false);
        return v;
    }

}
