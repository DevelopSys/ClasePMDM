package com.system.develop.t2_examen.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.develop.t2_examen.R;
import com.system.develop.t2_examen.utils.Generico;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    Context context;
    List lista;

    public AdaptadorSpinner(Context context) {
        this.context = context;
        lista = new ArrayList();
        lista.add(new Generico("Películas","peliculas", R.drawable.film));
        lista.add(new Generico("Videojuegos", "juegos",R.drawable.videogames));
        lista.add(new Generico("Fútbol", "deporte", R.drawable.soccer));
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Generico generico = (Generico) lista.get(position);
        holder.getNombre().setText(generico.getNombre());
        holder.getImagen().setImageResource(generico.getImagen());

        return convertView;
    }

    class ViewHolder {
        View view;
        ImageView imagen;
        TextView nombre;

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public ViewHolder(View view) {
            nombre = view.findViewById(R.id.nombreSpinner);
            imagen = view.findViewById(R.id.imagenSpinner);
        }
    }
}
