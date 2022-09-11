package com.borja.proyectoequipos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.proyectoequipos.R;
import com.borja.proyectoequipos.utils.Liga;

import java.util.List;

public class AdaptadorLigas extends RecyclerView.Adapter<AdaptadorLigas.MiHolder> {


    List<Liga> listaLigas;
    Context context;
    OnLigaListener listener;

    public AdaptadorLigas(List<Liga> listaLigas, Context context) {
        this.listaLigas = listaLigas;
        this.context = context;
        listener = (OnLigaListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_liga_layout
                ,parent,false);
        MiHolder holder = new MiHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {

        final Liga liga = listaLigas.get(position);
        holder.getImagenLiga().setImageResource(liga.getLogo());
        holder.getNombreLiga().setText(liga.getNombre());
        holder.getNombreLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLigaSelected(liga);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaLigas.size();
    }


    public interface OnLigaListener{
        void onLigaSelected(Liga liga);
    }

    class MiHolder extends RecyclerView.ViewHolder{

        private ImageView imagenLiga;
        private TextView nombreLiga;

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








