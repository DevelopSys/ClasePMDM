package com.borja.t04_dialogos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.borja.t04_dialogos.R;
import com.borja.t04_dialogos.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorDialogo extends BaseAdapter {

    Context context;
    ArrayList<Equipo> listaDatos;

    public AdaptadorDialogo(Context context, ArrayList<Equipo> listaDatos) {
        this.context = context;
        this.listaDatos = listaDatos;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaDatos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.item_dialogo, viewGroup, false);
        Equipo actual = listaDatos.get(i);
        ImageView imageView = view.findViewById(R.id.imagen_dialogo);
        TextView textView = view.findViewById(R.id.texto_dialogo);

        imageView.setImageResource(actual.getImagen());
        textView.setText(actual.getNombre());

        return view;
    }
}
