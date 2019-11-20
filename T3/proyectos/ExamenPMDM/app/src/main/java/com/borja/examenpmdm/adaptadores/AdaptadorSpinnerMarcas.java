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
import com.borja.examenpmdm.utils.Marca;

import java.util.List;

public class AdaptadorSpinnerMarcas extends BaseAdapter {


    List<Marca> listaMarcas;
    Context context;

    public AdaptadorSpinnerMarcas(List<Marca> listaMarcas, Context context) {
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

        view = LayoutInflater.from(context).inflate(R.layout.spinner_marca, viewGroup, false);
        Marca m = listaMarcas.get(i);
        ImageView imagen = view.findViewById(R.id.imagen_spinner_marca);
        TextView modelo = view.findViewById(R.id.nombre_spinner_marca);
        imagen.setImageResource(m.getLogo());
        modelo.setText(m.getMarca());
        return view;
    }
}
