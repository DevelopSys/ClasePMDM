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
import com.borja.practicaequipos.utils.Liga;

import java.util.ArrayList;

public class AdaptadorLigas extends RecyclerView.Adapter<AdaptadorLigas.MiHolder> {

    ArrayList listaDatos;
    Context context;
    OnLigaSelectedListener ligaSelectedListener;

    public AdaptadorLigas(ArrayList listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
        ligaSelectedListener = (OnLigaSelectedListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MiHolder(LayoutInflater.from(context).inflate(R.layout.ligas_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Liga liga = (Liga) listaDatos.get(position);
        holder.getNombreLiga().setText(liga.getNombre());
        holder.getImagenLiga().setImageResource(liga.getLogo());
        holder.getNombreLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligaSelectedListener.onLigaSelected(liga);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public interface OnLigaSelectedListener{
        void onLigaSelected(Liga l);
    }

    class MiHolder extends RecyclerView.ViewHolder{

        ImageView imagenLiga;
        TextView nombreLiga;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagenLiga = itemView.findViewById(R.id.imagen_liga);
            nombreLiga = itemView.findViewById(R.id.nombre_liga);
        }

        public ImageView getImagenLiga() {
            return imagenLiga;
        }

        public TextView getNombreLiga() {
            return nombreLiga;
        }
    }
}
