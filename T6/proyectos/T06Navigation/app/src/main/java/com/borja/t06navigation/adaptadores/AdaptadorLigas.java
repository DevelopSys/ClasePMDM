package com.borja.t06navigation.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t06navigation.R;
import com.borja.t06navigation.utils.Liga;

import java.util.ArrayList;

public class AdaptadorLigas extends RecyclerView.Adapter<AdaptadorLigas.MyHolder> {

    ArrayList<Liga> listaLigas;
    Context context;

    public AdaptadorLigas(Context context) {
        this.listaLigas = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_liga,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Liga liga = listaLigas.get(position);
        holder.getNombreLiga().setText(liga.getNombre());
        holder.getNombreLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO cualdo pulso ejecuto la interfaz de
                // callback para pasar al main el id de la
                // liga selaccionada
                Toast.makeText(context,String.valueOf(liga.getId()), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaLigas.size();
    }

    public void agregarElemento(Liga liga){
        listaLigas.add(liga);
        notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder{


        TextView nombreLiga;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombreLiga = itemView.findViewById(R.id.nombre_liga);
        }

        public TextView getNombreLiga() {
            return nombreLiga;
        }
    }
}
