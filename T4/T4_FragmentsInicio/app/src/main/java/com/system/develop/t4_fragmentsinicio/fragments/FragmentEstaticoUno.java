package com.system.develop.t4_fragmentsinicio.fragments;

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
import android.widget.EditText;
import android.widget.Toast;

import com.system.develop.t4_fragmentsinicio.R;

public class FragmentEstaticoUno extends Fragment {

    Button boton;
    EditText editText;
    OnFragmentUnoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentUnoListener) context;
        }catch (ClassCastException e){
            Log.v("Error", "tipos incompatibles");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_estatico_uno,container,false);
        boton = v.findViewById(R.id.botonFragmentUno);
        editText = v.findViewById(R.id.editFragmentUno);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"Has pulsado el botón",Toast.LENGTH_SHORT).show();
                if (!editText.getText().toString().isEmpty()){
                    listener.onFragmentUnoSelected(editText.getText().toString());
                }
                else Toast.makeText(getContext(),"no hay nada que pasar",Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    // origen defino una interfaz
    public interface OnFragmentUnoListener{
        public void onFragmentUnoSelected(String s);
    }
}
