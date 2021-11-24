package com.example.proyectomodelos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectomodelos.R;
import com.example.proyectomodelos.utils.Marca;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorMarcas extends BaseAdapter {

    private List<Marca> listMarcas;
    private Context context;

    public AdaptadorMarcas(List listMarcas, Context context) {
        this.listMarcas = listMarcas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listMarcas.size();
    }

    @Override
    public Object getItem(int position) {
        return listMarcas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Marca marcaActual = listMarcas.get(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.fila_spinner_marca, parent, false);
        TextView textoMarca = convertView.findViewById(R.id.texto_marca_fila);
        ImageView imagenMarca = convertView.findViewById(R.id.imagen_marca_fila);

        textoMarca.setText(marcaActual.getMarca());
        imagenMarca.setImageResource(marcaActual.getImagen());

        return convertView;
    }
}
