package com.system.develop.t4_viewpager.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.system.develop.t4_viewpager.R;

public class FragmentUno extends Fragment{

    View v;
    Button b;
    OnFragmentUnoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnFragmentUnoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fracment_uno_layout,container,false);
        b = v.findViewById(R.id.botonf1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentUnoSelected();
            }
        });
        return v;
    }

    public interface OnFragmentUnoListener{
        public void onFragmentUnoSelected();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
