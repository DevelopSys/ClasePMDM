package com.system.develop.t4_repaso.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.system.develop.t4_repaso.R;

public class FragmentEstatico extends Fragment {

    View v;
    Button button, button2;
    OnFragmentEstaticoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentEstaticoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.festatico_layout,container,false);
        button = v.findViewById(R.id.botonFEstatico);
        button2 = v.findViewById(R.id.botonFEstatico2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentEstaticoSelectedDos();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listener.onFragmentEstaticoSelected();
            }
        });
        return v;
    }

    public interface OnFragmentEstaticoListener{
        public void onFragmentEstaticoSelected();
        public void onFragmentEstaticoSelectedDos();
    }
}
