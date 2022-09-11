package com.borja.t3_elementos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.borja.t3_elementos.R;
import com.borja.t3_elementos.utils.Marca;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    ArrayList<Marca> listaDatos;
    Context context;

    public AdaptadorSpinner(ArrayList listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_fila_spinner,parent,false);

        // que se pone en cada una de las filas del spinner
        Marca marcaActual = listaDatos.get(position);
        ImageView imagenMarca = convertView.findViewById(R.id.imagen_marca_spinner);
        TextView nombreMarca = convertView.findViewById(R.id.texto_marca_spinner);

        imagenMarca.setImageResource(marcaActual.getImagen());
        nombreMarca.setText(marcaActual.getNombre());

        return convertView;
    }
}
