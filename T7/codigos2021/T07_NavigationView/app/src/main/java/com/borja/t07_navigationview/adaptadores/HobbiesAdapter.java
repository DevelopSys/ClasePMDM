package com.borja.t07_navigationview.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t07_navigationview.R;
import com.borja.t07_navigationview.utils.Hobbie;

import java.util.ArrayList;

public class HobbiesAdapter extends RecyclerView.Adapter<HobbiesAdapter.MyHolder> {

    private Context context;
    private ArrayList<Hobbie> lista;
    // TODO listener

    public HobbiesAdapter(Context context, ArrayList<Hobbie> lista){
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hobbie,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Hobbie hobbieActual = lista.get(position);
        holder.getImagen().setImageResource(hobbieActual.getImagen());
        holder.getTexto().setText(hobbieActual.getNombre());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView texto;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_hobbie);
            texto = itemView.findViewById(R.id.nombre_hobbie);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getTexto() {
            return texto;
        }
    }
}
