package com.example.listas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.listas.R;
import com.example.listas.utils.Modelo;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    ArrayList<Modelo> listaModelos;
    Context context;

    public AdaptadorLista(ArrayList<Modelo> listaModelos, Context context) {
        this.listaModelos = listaModelos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaModelos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaModelos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false);
        Modelo modeloActual = listaModelos.get(position);

        ImageView imagen = convertView.findViewById(R.id.imagen_item_lista);
        TextView texto = convertView.findViewById(R.id.texto_item_lista);

        texto.setText(modeloActual.getNombre());
        imagen.setImageResource(modeloActual.getImagen());


        return convertView;
    }
}
