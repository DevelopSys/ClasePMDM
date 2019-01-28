package com.system.develop.t4_masterdetail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.system.develop.t4_masterdetail.R;

public class FragmentUno extends Fragment {

    Button boton;
    OnFragmentUnoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentUnoListener) context;

        } catch (ClassCastException e){
            Log.v("error","No se ha podido castear");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_uno, container, false);
        boton = v.findViewById(R.id.botonf1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentUnoSelected();
            }
        });
        return v;
    }

    public interface OnFragmentUnoListener {
        public void onFragmentUnoSelected();
    }

}
