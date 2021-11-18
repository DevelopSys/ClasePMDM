package com.example.listas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listas.R;
import com.example.listas.utils.Coche;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    private List<Coche> listaCoches;
    private Context context;


    public AdaptadorSpinner(List<Coche> listaCoches, Context context) {
        this.listaCoches = listaCoches;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCoches.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCoches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_layout,parent,false);

        ImageView imagenMarca = convertView.findViewById(R.id.imagen_fila_spinner);
        TextView textModelo = convertView.findViewById(R.id.modelo_fila_spinner) ;
        TextView textCv = convertView.findViewById(R.id.cv_fila_spinner);

        Coche itemCoche = listaCoches.get(position);
        imagenMarca.setImageResource(itemCoche.getImagen());
        textModelo.setText(itemCoche.getModelo());
        textCv.setText(String.valueOf(itemCoche.getCv()));

        return convertView;
    }
}
