package com.example.listas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listas.R;
import com.example.listas.utils.Marca;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    private List<Marca> listaMarcas;
    private Context context;

    public AdaptadorSpinner(List<Marca> listaMarcas, Context context) {
        this.listaMarcas = listaMarcas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaMarcas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMarcas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addMarca(Marca marca){
        listaMarcas.add(marca);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner,parent,false );
        Marca marcaActual = listaMarcas.get(position);
        ImageView imagen = convertView.findViewById(R.id.imagen_item_spinner) ;
        imagen.setImageResource(marcaActual.getImagen());
        TextView texto = convertView.findViewById(R.id.texto_item_spinner);
        texto.setText(marcaActual.getNombre());
        return convertView;
    }
}
