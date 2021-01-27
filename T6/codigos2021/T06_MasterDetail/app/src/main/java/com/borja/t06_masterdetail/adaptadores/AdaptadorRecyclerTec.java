package com.borja.t06_masterdetail.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t06_masterdetail.R;
import com.borja.t06_masterdetail.utils.Tecnologia;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecyclerTec extends RecyclerView.Adapter<AdaptadorRecyclerTec.MyHolder> {

    List<Tecnologia> listaTecnologias;
    Context context;

    public AdaptadorRecyclerTec(List<Tecnologia> listaTecnologias, Context context) {
        this.listaTecnologias = listaTecnologias;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tecnologia_recycler,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Tecnologia tecnologia = listaTecnologias.get(position);
        holder.getImagen().setImageResource(tecnologia.getLogo());
        holder.getNombre().setText(tecnologia.getNombre());


    }

    @Override
    public int getItemCount() {
        return listaTecnologias.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView nombre;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.image_recycle);
            nombre = itemView.findViewById(R.id.texto_recycler);
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
