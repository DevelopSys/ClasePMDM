package com.example.json.adapters;

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
import com.example.json.R;
import com.example.json.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorJSON extends RecyclerView.Adapter<AdaptadorJSON.MyHolder> {

    private ArrayList<Equipo> listaEquipo;
    private Context context;
    private OnEquipoListener listener;

    public AdaptadorJSON(Context context) {
        //this.listaEquipo = listaEquipo;
        listaEquipo = new ArrayList<>();
        this.context = context;
        listener = (OnEquipoListener) context;
    }

    public void agregarEquipo(Equipo equipo){
        listaEquipo.add(equipo);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Equipo equipo = listaEquipo.get(position);
        holder.nombre.setText(equipo.getNombre());
        Glide.with(context).load(equipo.getEscudo())
                .placeholder(R.drawable.escudo).into(holder.imagen);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEquipoSelected(equipo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaEquipo.size();
    }

    public interface OnEquipoListener{

        void onEquipoSelected(Equipo equipo);

    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView imagen;
        LinearLayout linearLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_equipo);
            imagen = itemView.findViewById(R.id.imagen_escudo);
            linearLayout = itemView.findViewById(R.id.liner_fila);
        }
    }
}
