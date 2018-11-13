package com.system.develop.t2_02_listaspinner.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.system.develop.t2_02_listaspinner.R;
import com.system.develop.t2_02_listaspinner.utils.Persona;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {

    Context context;
    List listaDatos;

    public AdaptadorSpinner(Context context, List listaDatos) {
        this.context = context;
        this.listaDatos = listaDatos;
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

        Persona p = (Persona) listaDatos.get(position);
        holder.getNombre().setText(p.getNombre());
        holder.getApellido().setText(p.getApellido());

        return convertView;
    }

    class ViewHolder {
        View v;
        TextView nombre, apellido;

        public ViewHolder(View v) {
            this.v = v;
            nombre = v.findViewById(R.id.textoSpinnerNormal);
            apellido = v.findViewById(R.id.textoSpinnerANormalDos);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}
