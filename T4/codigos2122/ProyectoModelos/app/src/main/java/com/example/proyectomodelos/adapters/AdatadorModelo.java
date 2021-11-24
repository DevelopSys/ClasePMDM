package com.example.proyectomodelos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectomodelos.R;
import com.example.proyectomodelos.utils.Modelo;

import java.util.List;

public class AdatadorModelo extends BaseAdapter {

    List<Modelo> listaModelo;
    Context context;

    public AdatadorModelo(List<Modelo> listaModelo, Context context) {
        this.listaModelo = listaModelo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaModelo.size();
    }

    @Override
    public Object getItem(int position) {
        return listaModelo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Modelo modeloActual = listaModelo.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.fila_listview_modelo, parent,false);

        TextView textoModelo = convertView.findViewById(R.id.texto_modelo_fila);
        ImageView imagenModelo = convertView.findViewById(R.id.imagen_modelo_fila);

        textoModelo.setText(modeloActual.getModelo());
        imagenModelo.setImageResource(modeloActual.getImagen());

        return convertView;
    }
}
