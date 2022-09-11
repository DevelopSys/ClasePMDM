package com.borja.t06_fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06_fragments.R;

public class FragmentDinamicoUno extends Fragment {

    private Button btnComunicar;
    private EditText editNombre;
    private Context context;
    private View v;
    private OnFragmentUnoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            listener = (OnFragmentUnoListener) context;
        } catch (ClassCastException e){

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_dinamico_uno,container,false);

        btnComunicar = v.findViewById(R.id.button_f1);
        editNombre = v.findViewById(R.id.edit_f1);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnComunicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context,editNombre.getText().toString(),Toast.LENGTH_SHORT).show();
                listener.onFragmentUnoSelected(editNombre.getText().toString());
            }
        });
    }

    public interface OnFragmentUnoListener{
        void onFragmentUnoSelected(String nombre);
    }
}
