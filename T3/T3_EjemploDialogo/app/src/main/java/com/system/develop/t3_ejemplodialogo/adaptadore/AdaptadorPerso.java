package com.system.develop.t3_ejemplodialogo.adaptadore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.develop.t3_ejemplodialogo.R;
import com.system.develop.t3_ejemplodialogo.utils.Elemento;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPerso extends BaseAdapter {

    List lista;
    Context context;

    public AdaptadorPerso(List lista, Context context) {
        this.lista = lista;
        this.context = context;
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

        Holder holder;
        if (convertView==null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_spinner,parent,false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        Elemento e = (Elemento) lista.get(position);
        holder.getImagen().setImageResource(e.getImagen());
        holder.getNombre().setText(e.getNombre());

        return convertView;
    }

    class Holder{
        ImageView imagen;
        TextView nombre;

        public Holder(View v) {
            imagen = v.findViewById(R.id.imagenSp);
            nombre = v.findViewById(R.id.nombreSp);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }
    }
}
