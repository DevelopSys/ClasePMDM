package com.borja.t06_masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06_masterdetail.R;

public class FragmentMaster extends Fragment {

    private Button botonMaster;
    private OnFragmentMasterListener listener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentMasterListener) context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_layout,container,false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void acciones() {
        botonMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Pulsado desde Master",Toast.LENGTH_SHORT).show();
                listener.onFragmentMasterSelected();
            }
        });
    }

    private void instancias() {
        botonMaster = getView().findViewById(R.id.boton_master);
    }

    public interface OnFragmentMasterListener{
        void onFragmentMasterSelected();
    }






}
