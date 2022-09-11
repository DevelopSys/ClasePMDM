package com.borja.t06_masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.borja.t06_masterdetail.R;
import com.borja.t06_masterdetail.utils.Tecnologia;


public class FragmentDetail extends Fragment {

    private View view;
    private TextView nombre, descripcion;
    private Tecnologia tecnologia;
    private ImageView imagen;

    public static FragmentDetail newInstance(Tecnologia tecnologia) {


        Bundle args = new Bundle();
        args.putSerializable("tecnologia",tecnologia);
        FragmentDetail fragment = new FragmentDetail();
        fragment.setArguments(args);
        return fragment;
        // FragmentDetalleTecnologia ft = new FragmentDetalleTecnologia()
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        tecnologia = (Tecnologia) this.getArguments().getSerializable("tecnologia");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_layout,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imagen = view.findViewById(R.id.imagen_detalle_tec);
        nombre = view.findViewById(R.id.nombre_detalle_tec);
        descripcion = view.findViewById(R.id.descripcion_detalle_tec);
        imagen.setImageResource(tecnologia.getLogo());
        nombre.setText(tecnologia.getNombre());
        descripcion.setText(tecnologia.getCaracteristicas());
    }
}
