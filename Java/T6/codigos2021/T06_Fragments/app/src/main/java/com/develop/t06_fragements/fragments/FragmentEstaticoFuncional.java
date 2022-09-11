package com.develop.t06_fragements.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.develop.t06_fragements.R;

public class FragmentEstaticoFuncional extends Fragment implements View.OnClickListener {

    private View v;
    private Button bF1, bF2, bF3, bBuscar;
    private EditText editBuscar;
    private OnFragmentFuncionalListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentFuncionalListener) context;
        } catch (ClassCastException e){
            Log.v("casteo","No se puede hacer este casteo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.layout_fragmnent_funcional, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void acciones() {
        bF1.setOnClickListener(this);
        bF2.setOnClickListener(this);
        bF3.setOnClickListener(this);
        bBuscar.setOnClickListener(this);
    }

    private void instancias() {
        bF1 = v.findViewById(R.id.button_ir_f1);
        bF2 = v.findViewById(R.id.button_ir_f2);
        bF3 = v.findViewById(R.id.button_ir_f3);
        bBuscar = v.findViewById(R.id.button_buscar_fg);
        editBuscar = v.findViewById(R.id.edit_buscar);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_ir_f1:
                // Toast.makeText(getContext(),"Pulsado desde FG",Toast.LENGTH_SHORT).show();
                // pulso y se ejecuta una accion en el mainAct
                listener.comunicarPulsacion("f1");
                break;
            case R.id.button_ir_f2:
                listener.comunicarPulsacion("f2");
                break;
            case R.id.button_ir_f3:
                listener.comunicarPulsacion("f3");
                break;
            case R.id.button_buscar_fg:
                listener.buscarFragment(editBuscar.getText().toString());

                break;
        }
    }

    public interface OnFragmentFuncionalListener{

        void comunicarPulsacion(String tag);
        void buscarFragment(String tag);

    }
}
