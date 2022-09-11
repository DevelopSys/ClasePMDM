package com.borja.t06navigation.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t06navigation.R;
import com.borja.t06navigation.utils.Equipo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MyHolder> {

    private ArrayList<Equipo> listaEquipos;
    private Context context;


    public AdaptadorEquipos(Context context) {
        this.listaEquipos = new ArrayList();
        this.context = context;
    }

    public void agregarEquipo(Equipo equipo){
        listaEquipos.add(equipo);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_equipo,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        final Equipo equipo = listaEquipos.get(position);
        holder.getNombre().setText(equipo.getNombre());
        Glide.with(context).load(equipo.getImagen()).into(holder.getImagen());
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView nombre;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_equipo);
            nombre = itemView.findViewById(R.id.nombre_equipo);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }
    }
}
