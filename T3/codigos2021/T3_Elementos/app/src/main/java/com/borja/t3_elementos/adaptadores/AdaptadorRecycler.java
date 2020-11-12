package com.borja.t3_elementos.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t3_elementos.ListasPersoActivity;
import com.borja.t3_elementos.R;
import com.borja.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    ArrayList<Coche> listaDatos;
    Context context;

    public AdaptadorRecycler(ArrayList<Coche> listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context)
                .inflate(R.layout.item_fila_recycler,parent,false);
        MiHolder holder = new MiHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {

        final Coche cocheActual = listaDatos.get(position);
        //cocheActual.getMarca();
        // no meto findviews
        holder.getMarca().setText(cocheActual.getMarca());
        holder.getModelo().setText(cocheActual.getModelo());
        holder.getImagen().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(context,String.valueOf(cocheActual.getCv()),Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(context, ListasPersoActivity.class);
                //context.startActivity(intent);
                return true;
            }
        });
    }
    @Override
    public int getItemCount() {
        return listaDatos.size();
    }
    class MiHolder extends RecyclerView.ViewHolder{

        private TextView marca, modelo;
        private ImageView imagen;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            marca = itemView.findViewById(R.id.marca_recycler_perso);
            modelo = itemView.findViewById(R.id.modelo_recycler_perso);
            imagen = itemView.findViewById(R.id.imagen_recycler_perso);
        }

        public TextView getMarca() {
            return marca;
        }
        public TextView getModelo() {
            return modelo;
        }
        public ImageView getImagen() {
            return imagen;
        }
    }

}
