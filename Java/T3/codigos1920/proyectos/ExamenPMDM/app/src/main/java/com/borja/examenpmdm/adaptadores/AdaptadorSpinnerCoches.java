package com.borja.examenpmdm.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.borja.examenpmdm.R;
import com.borja.examenpmdm.utils.Coche;

import java.util.List;

public class AdaptadorSpinnerCoches extends BaseAdapter {


    List<Coche> listaCoches;
    Context context;

    public AdaptadorSpinnerCoches(List<Coche> listaCoches, Context context) {
        this.listaCoches = listaCoches;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCoches.size();
    }

    @Override
    public Object getItem(int i) {
        return listaCoches.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.spinner_coches, viewGroup, false);
        Coche c = listaCoches.get(i);
        ImageView imagen = view.findViewById(R.id.imagen_spinner_coche);
        TextView modelo = view.findViewById(R.id.nombre_spinner_coche);
        imagen.setImageResource(c.getImagen());
        modelo.setText(c.getModelo());
        return view;
    }
}
