package com.example.t6_iniciofg.fragements;

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

import com.example.t6_iniciofg.R;

public class FragmentUno extends Fragment {

    private View view;
    private EditText editFragment;
    private Button buttonFragment;
    private OnFragmentUnoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentUnoListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_uno_layout,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();

    }

    private void acciones() {
        buttonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = editFragment.getText().toString();
                //Toast.makeText(getContext(), dato, Toast.LENGTH_SHORT).show();
                listener.onDataSelected(dato);
            }
        });
    }

    private void instancias() {
        buttonFragment = view.findViewById(R.id.boton_comunicar_f1);
        editFragment = view.findViewById(R.id.edit_fragment1);
    }

    public interface OnFragmentUnoListener{
        void onDataSelected(String data);
    }
}
