package com.borja.practicaequipos.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.borja.practicaequipos.R;
import com.borja.practicaequipos.utils.Jugador;

import java.util.ArrayList;

public class AdaptadorJugador extends BaseAdapter {


    ArrayList lista;
    Context context;

    public AdaptadorJugador(ArrayList lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.equipos_layout, viewGroup, false);

        Jugador j = (Jugador) lista.get(i);

        LinearLayout linearLayout = view.findViewById(R.id.layout_jugador);
        TextView nombre = view.findViewById(R.id.nombre_jugador);
        ImageView estrella = view.findViewById(R.id.imagen_estrella);

        if (j.isEstrella()){
            estrella.setVisibility(View.VISIBLE);
        } else {
            estrella.setVisibility(View.INVISIBLE);
        }

        nombre.setText(j.getNombre());


        return view;
    }
}
