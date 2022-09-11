package com.example.peticionesjson.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.peticionesjson.R;
import com.example.peticionesjson.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MyHolder> {

    private ArrayList<Equipo> listaEquipos;
    private Context context;
    private OnEquipoListener listener;

    public AdaptadorEquipos(Context context) {
        this.listaEquipos = new ArrayList<>();
        this.context = context;
        this.listener = (OnEquipoListener) context;
    }



    public void agregarEquipo (Equipo equipo){
        this.listaEquipos.add(equipo);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Equipo equipoActual = listaEquipos.get(position);
        holder.nombre.setText(equipoActual.getNombre());
        holder.estadio.setText(equipoActual.getEstadio());
        Glide.with(context).load(equipoActual.getImagen()).placeholder(R.drawable.escudo_place).into(holder.escudo);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // ejecutado con la pulsacion de la fila
              listener.onEquipoSelected(equipoActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    public interface OnEquipoListener{

        void onEquipoSelected(Equipo equipo);

    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView nombre, estadio;
        ImageView escudo;
        LinearLayout linearLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_item);
            estadio = itemView.findViewById(R.id.estadio_item);
            escudo = itemView.findViewById(R.id.imagen_item);
            linearLayout = itemView.findViewById(R.id.fila_item);
        }

    }
}
