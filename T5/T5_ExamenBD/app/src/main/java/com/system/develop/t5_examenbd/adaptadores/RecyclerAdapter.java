package com.system.develop.t5_examenbd.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.system.develop.t5_examenbd.R;
import com.system.develop.t5_examenbd.utils.Alumno;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HolderAdapter> {

    Context c;
    ArrayList<Alumno> lista;

    public RecyclerAdapter(Context c, ArrayList<Alumno> lista) {
        this.c = c;
        this.lista = lista;
    }

    @NonNull
    @Override
    public HolderAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler,viewGroup,false);
        return new HolderAdapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAdapter holderAdapter, int i) {
        Alumno a = lista.get(i);
        holderAdapter.getNombre().setText(a.getNombre());
        holderAdapter.getApellido().setText(a.getApellido());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class HolderAdapter extends RecyclerView.ViewHolder{


        TextView nombre, apellido;

        public HolderAdapter(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreItem);
            apellido = itemView.findViewById(R.id.apellidoItem);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}
