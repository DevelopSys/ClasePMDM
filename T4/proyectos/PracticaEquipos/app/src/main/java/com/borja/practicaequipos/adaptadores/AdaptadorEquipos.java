package com.borja.practicaequipos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.practicaequipos.R;
import com.borja.practicaequipos.utils.Equipo;
import com.borja.practicaequipos.utils.Liga;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MiHolder> {

    ArrayList listaDatos;
    Context context;
    OnEquipoSelectedListener equipoListener;

    public AdaptadorEquipos(ArrayList listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
        equipoListener = (OnEquipoSelectedListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MiHolder(LayoutInflater.from(context).inflate(R.layout.ligas_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Equipo equipo = (Equipo) listaDatos.get(position);
        holder.getNombreEquipo().setText(equipo.getNombre());
        if (equipo.getEscudo()!=0){
            holder.getImagenEquipo().setImageResource(equipo.getEscudo());
        }
        holder.getNombreEquipo().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipoListener.onEquipoSelected(equipo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public interface OnEquipoSelectedListener{
        void onEquipoSelected(Equipo e);
    }

    class MiHolder extends RecyclerView.ViewHolder{

        ImageView imagenEquipo;
        TextView nombreEquipo;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagenEquipo = itemView.findViewById(R.id.imagen_liga);
            nombreEquipo = itemView.findViewById(R.id.nombre_liga);
        }

        public ImageView getImagenEquipo() {
            return imagenEquipo;
        }

        public TextView getNombreEquipo() {
            return nombreEquipo;
        }
    }
}
