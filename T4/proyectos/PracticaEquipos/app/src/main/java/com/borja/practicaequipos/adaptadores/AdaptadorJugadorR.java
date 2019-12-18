package com.borja.practicaequipos.adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.practicaequipos.R;
import com.borja.practicaequipos.utils.Jugador;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorJugadorR extends RecyclerView.Adapter<AdaptadorJugadorR.MiHolder> {


    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagenEstrella;
        TextView nombreJugador;
        LinearLayout layoutJugador;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagenEstrella = itemView.findViewById(R.id.imagen_estrella);
            nombreJugador = itemView.findViewById(R.id.nombre_jugador);
            layoutJugador = itemView.findViewById(R.id.layout_jugador);
        }

        public LinearLayout getLayoutJugador() {
            return layoutJugador;
        }

        public ImageView getImagenEstrella() {
            return imagenEstrella;
        }

        public TextView getNombreJugador() {
            return nombreJugador;
        }
    }


    ArrayList lista;
    Context context;

    public AdaptadorJugadorR(ArrayList lista, Context context) {
        this.lista = lista;
        this.context = context;
    }


    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MiHolder(LayoutInflater.from(context).inflate(R.layout.equipos_layout, parent, false));
    }

    public void onBindViewHolder(@NonNull MiHolder holder, int position) {


        Jugador j = (Jugador) lista.get(position);

        if (j.isEstrella()) {
            holder.getImagenEstrella().setVisibility(View.VISIBLE);
        } else {
            holder.getImagenEstrella().setVisibility(View.INVISIBLE);
        }

        if (j.getPosicion().equals("Delantero")){
            holder.getLayoutJugador().setBackgroundColor(context.getResources().getColor(R.color.colorDelantero,null));
        }else if (j.getPosicion().equals("Medio")){
            holder.getLayoutJugador().setBackgroundColor(context.getResources().getColor(R.color.colorMedio,null));
        }else if (j.getPosicion().equals("Defensa")){
            holder.getLayoutJugador().setBackgroundColor(context.getResources().getColor(R.color.colorDefensa,null));
        } else if (j.getPosicion().equals("Portero")){
            holder.getLayoutJugador().setBackgroundColor(context.getResources().getColor(R.color.colorPortero,null));
        }

        holder.getNombreJugador().setText(j.getNombre().toUpperCase()+" "+j.getApellido());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
