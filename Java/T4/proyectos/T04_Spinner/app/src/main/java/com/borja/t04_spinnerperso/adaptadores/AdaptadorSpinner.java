package com.borja.t04_spinnerperso.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.borja.t04_spinnerperso.R;
import com.borja.t04_spinnerperso.utils.Marca;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    ArrayList<Marca> listaDatos;
    Context c;

    public AdaptadorSpinner(ArrayList<Marca> listaDatos, Context c) {
        this.listaDatos = listaDatos;
        this.c = c;
    }

    // numero de filas o elementos que tendrá el spinner
    // del array de elementos (de marcas)
    @Override
    public int getCount() {
        return listaDatos.size();
    }

    // obtiene el objeto de la posicion correspondiente (i)
    // lista.get(i)
    @Override
    public Object getItem(int i) {
        return listaDatos.get(i);
    }

    // obtiene el id del elemento de la posicion corresponidente
    // lista.get(i).getID();
    @Override
    public long getItemId(int i) {
        return i;
    }


    // renderiza cada una de las fias
    // traigo el xml creado
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(c).inflate(R.layout.spinner_personalizado,
                viewGroup,false);

        Marca mActual = listaDatos.get(i);

        TextView nombre = view.findViewById(R.id.texto_spinner);
        ImageView imagen = view.findViewById(R.id.imagen_spinner);

        nombre.setText(mActual.getNombre());
        imagen.setImageResource(mActual.getLogo());

        return view;
    }
}
