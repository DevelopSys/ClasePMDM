package com.borja.proyectoequipos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.proyectoequipos.R;
import com.borja.proyectoequipos.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MiHolder> {

    ArrayList<Equipo> lista;
    Context context;
    OnEquipoListener listener;


    public AdaptadorEquipos(ArrayList<Equipo> lista, Context context) {
        this.lista = lista;
        this.context = context;
        listener = (OnEquipoListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_equipo_layout,parent,false);
        MiHolder holder = new MiHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {

        final Equipo equipo = lista.get(position);
        holder.getNombre().setText(equipo.getNombre());
        holder.getLogo().setImageResource(equipo.getEscudo());
        holder.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEquipoSelected(equipo);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnEquipoListener{
        void onEquipoSelected(Equipo equipo);
    }

    class MiHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        ImageView logo;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_equipo);
            logo = itemView.findViewById(R.id.imagen_equipo);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getLogo() {
            return logo;
        }
    }
}
