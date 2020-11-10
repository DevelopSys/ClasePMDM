package com.borja.t3_elementos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.borja.t3_elementos.ListasPersoActivity;
import com.borja.t3_elementos.R;
import com.borja.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    ArrayList<Coche> listaElementos;
    int[] logos = new int[]{R.drawable.ford,R.drawable.audi};
    Context context;

    public AdaptadorLista(ArrayList lista, Context context){
        this.listaElementos = lista;
        this.context = context;
    }

    // cuantas filas tiene la lista - spinner
    @Override
    public int getCount() {
        return listaElementos.size();
    }

    // retorna el objeto de cada fila
    @Override
    public Object getItem(int position) {
        return listaElementos.get(position);
    }

    // retorna el id del elemento que está en una posición
    @Override
    public long getItemId(int position) {
        return position;
    }

    // retorna la vista de la fila ya pintada
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textMarca, textModelo;
        ImageView imagenCoche;

        convertView = LayoutInflater.from(context).inflate(R.layout.item_fila_lista
                ,parent,false);

        Coche cocheActual = listaElementos.get(position);

        textMarca = convertView.findViewById(R.id.marca_lista_perso);
        textModelo = convertView.findViewById(R.id.modelo_lista_perso);
        imagenCoche = convertView.findViewById(R.id.imagen_lista_perso);

        textMarca.setText(cocheActual.getMarca());
        textModelo.setText(cocheActual.getModelo());
        if (cocheActual.getMarca().equals("Mercedes")){
            imagenCoche.setImageResource(R.drawable.sport);
        } else if (cocheActual.getMarca().equals("Audi") || cocheActual.getMarca().equals("Volvo")){
            imagenCoche.setImageResource(R.drawable.luxury);
        } else {
            imagenCoche.setImageResource(R.drawable.normal);
        }

        return convertView;
    }
}
