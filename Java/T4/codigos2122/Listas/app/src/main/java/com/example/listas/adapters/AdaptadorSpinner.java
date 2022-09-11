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

import java.util.ArrayList;
import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    private ArrayList<Coche> listaCoches;
    private Context context;

    public AdaptadorSpinner(ArrayList<Coche> listaCoches, Context context) {
        this.listaCoches = listaCoches;
        this.context = context;
    }

    public AdaptadorSpinner(Context context) {
        this.listaCoches = new ArrayList<>();
        this.context = context;
    }

    // añadir elemento;

    public void addCoche(Coche coche){
        listaCoches.add(coche);
        notifyDataSetChanged();
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

    // tantas veces ejecutado como numero indique getCount()
    // el parámetro position toma valores de 0 - getConunt()-1
    // converView es la vista (ya rellena) que va a representar
    // parent es el elemento donde se va a representar la vista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // traigo el xml al código
        convertView = LayoutInflater.from(context).
                inflate(R.layout.spinner_layout,parent,false);

        TextView modelo = convertView.findViewById(R.id.modelo_fila_spinner);
        TextView cv  = convertView.findViewById(R.id.cv_fila_spinner);;
        ImageView imagen = convertView.findViewById(R.id.imagen_fila_spinner);;

        Coche itemAux = listaCoches.get(position);
        modelo.setText(itemAux.getModelo());
        cv.setText(String.valueOf(itemAux.getCv()));
        imagen.setImageResource(itemAux.getImagen());


        return convertView;
    }
}
