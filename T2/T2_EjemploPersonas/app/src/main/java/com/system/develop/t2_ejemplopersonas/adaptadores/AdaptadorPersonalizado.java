package com.system.develop.t2_ejemplopersonas.adaptadores;

import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.system.develop.t2_ejemplopersonas.R;
import com.system.develop.t2_ejemplopersonas.utils.Persona;

import java.util.List;

public class AdaptadorPersonalizado extends BaseAdapter {

    List<Persona> listaDatos;
    Context context;

    public AdaptadorPersonalizado(List<Persona> listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void agregarPersona(Persona persona){
        listaDatos.add(persona);
        notifyDataSetChanged();
    }

    public void borrarPersona(int posicion){
        listaDatos.remove(posicion);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        HolderPropio holder;

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false);
            holder = new HolderPropio(convertView);
            convertView.setTag(holder);
        }
        else {
           holder = (HolderPropio) convertView.getTag();
        }



        Persona p = listaDatos.get(position);
        holder.getNombreHolder().setText(p.getNombre());
        holder.getApellidoHolder().setText(p.getApellido());
        holder.getNombreHolder().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                borrarPersona(position);
                return true;
            }
        });

        return convertView;
    }

    class HolderPropio{
        TextView nombreHolder;
        TextView apellidoHolder;

        public HolderPropio(View view) {
            nombreHolder = view.findViewById(R.id.nombrePersona);
            apellidoHolder = view.findViewById(R.id.apellidoPersona);
        }

        public TextView getNombreHolder() {
            return nombreHolder;
        }

        public TextView getApellidoHolder() {
            return apellidoHolder;
        }
    }
}
