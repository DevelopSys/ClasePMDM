package com.borja.t06_comunicacionfragments.fragments;

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

import com.borja.t06_comunicacionfragments.R;

public class FragmentUno extends Fragment {

    private Button bComunicar;
    private EditText eTexto;
    private OnFragmentUnoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentUnoListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_uno_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bComunicar = getView().findViewById(R.id.boton_comunicar);
        eTexto = getView().findViewById(R.id.edit_fragment_uno);
        bComunicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getContext(),"Mostrar TOAST desde fragment",Toast.LENGTH_SHORT).show();
                //listener.onFragmentUnoSelected();
                if (!eTexto.getText().toString().isEmpty()) {
                    listener.onFragmentTextSelected(eTexto.getText().toString());
                }
            }
        });
    }

    public interface OnFragmentUnoListener {
        void onFragmentUnoSelected();

        void onFragmentTextSelected(String texto);
    }

}
