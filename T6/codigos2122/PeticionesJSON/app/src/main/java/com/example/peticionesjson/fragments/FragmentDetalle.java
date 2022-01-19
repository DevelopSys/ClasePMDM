package com.example.peticionesjson.fragments;

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

import com.bumptech.glide.Glide;
import com.example.peticionesjson.R;
import com.example.peticionesjson.utils.Equipo;

import java.util.PrimitiveIterator;

public class FragmentDetalle extends Fragment {

    private View view;
    private ImageView imagen;
    private TextView nombre, id, estadio, detalle;
    private Equipo equipoRecuperado;

    public static FragmentDetalle newInstance(Equipo equipo) {

        Bundle args = new Bundle();
        args.putSerializable("equipo", equipo);

        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments() != null){
            equipoRecuperado = (Equipo) this.getArguments().getSerializable("equipo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_detalle,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        initGUI();
    }

    private void initGUI() {
        nombre.setText(equipoRecuperado.getNombre());
        id.setText(equipoRecuperado.getId());
        estadio.setText(equipoRecuperado.getEstadio());
        Glide.with(getContext()).load(equipoRecuperado.getImagen()).placeholder(R.drawable.escudo_place).into(imagen);
        detalle.setText(equipoRecuperado.getDetalle());
    }

    private void instancias() {
        imagen = view.findViewById(R.id.imagen_detalle);
        nombre = view.findViewById(R.id.nombre_detalle);
        estadio = view.findViewById(R.id.estadio_detalle);
        id = view.findViewById(R.id.id_detalle);
        detalle = view.findViewById(R.id.texto_detalle);
    }
}
