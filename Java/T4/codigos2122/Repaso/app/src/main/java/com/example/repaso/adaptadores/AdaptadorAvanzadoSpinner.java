package com.example.repaso.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.repaso.R;
import com.example.repaso.utils.Marca;

import java.util.List;

public class AdaptadorAvanzadoSpinner extends BaseAdapter {

    private List<Marca> listaDatos;
    private Context context;

    public AdaptadorAvanzadoSpinner(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    // cuantas filas vas a tener que pintar
    // numero de elementos que tenga una lista
    @Override
    public int getCount() {
        return listaDatos.size();
    }

    // obtengo el elemento que esta en una posicion
    // si tengo una lista y tengo una posicion, tengo elemento
    // lista.get(posicion)
    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    // obtengo el id del elemento que esta en una posicion
    // posicion
    @Override
    public long getItemId(int position) {
        return position;
    }

    // se encarga de pintar cada una de las filas y de
    // rellenarlas
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner,
                parent,false);

        Marca itemActual = listaDatos.get(position);
        //itemActual.getImagen();
        //itemActual.getNombre();

        ImageView imagen = convertView.findViewById(R.id.imagen_item_spinner);
        TextView textView =  convertView.findViewById(R.id.texto_item_spinner);

        imagen.setImageResource(itemActual.getImagen());
        textView.setText(itemActual.getNombre());

        return convertView;
    }
}
