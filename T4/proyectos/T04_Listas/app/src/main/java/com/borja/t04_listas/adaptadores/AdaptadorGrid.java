package com.borja.t04_listas.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.borja.t04_listas.R;
import com.borja.t04_listas.utils.Marca;

import java.util.List;

public class AdaptadorGrid extends BaseAdapter {

    List<Marca> listaMarcas;
    Context context;

    public AdaptadorGrid(List listaMarcas, Context context) {
        this.listaMarcas = listaMarcas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaMarcas.size();
    }

    @Override
    public Object getItem(int i) {
        return listaMarcas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.lista_layout,
                    viewGroup, false);
        }
        Marca marcaPosicion = listaMarcas.get(i);
        TextView nombre = view.findViewById(R.id.nombre_marca);
        ImageView imagen = view.findViewById(R.id.imagen_marca);
        nombre.setText(marcaPosicion.getMarca());
        imagen.setImageResource(marcaPosicion.getLogo());


        return view;
    }
}
