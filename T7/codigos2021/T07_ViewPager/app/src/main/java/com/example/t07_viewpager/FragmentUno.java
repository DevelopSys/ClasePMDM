package com.example.t07_viewpager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentUno extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.v("fragment","OnAttach 1");
    }

    public void cambiarTexto(){
        // cambia el texto de algo que hay dentro
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v("fragment","OnDettach 1");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_uno, container,false);
        return view;
    }
}
