package com.example.recycler.adapters;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler.R;
import com.example.recycler.utils.Modelo;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {


    private List<Modelo> listaElementos;
    private Context context;
    private OnModeloRecyclerListener listener;

    public AdaptadorRecycler(List listaElementos, Context context) {
        this.listaElementos = listaElementos;
        this.context = context;
        this.listener = (OnModeloRecyclerListener) context;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Modelo modeloActual = listaElementos.get(position);
        holder.getImagen().setImageResource(modeloActual.getImagen());
        holder.getTitulo().setText(modeloActual.getModelo());
        holder.getSubTitulo().setText(modeloActual.getMarca());

        holder.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,String.valueOf(modeloActual.getPotencia()),Toast.LENGTH_SHORT).show();
                listener.onModeloSelected(modeloActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaElementos.size();
    }



    class MyHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView titulo, subTitulo;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_item_recycler);
            titulo = itemView.findViewById(R.id.titulo_item_recycler);
            subTitulo = itemView.findViewById(R.id.subtitulo_item_recycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getTitulo() {
            return titulo;
        }

        public void setTitulo(TextView titulo) {
            this.titulo = titulo;
        }

        public TextView getSubTitulo() {
            return subTitulo;
        }

        public void setSubTitulo(TextView subTitulo) {
            this.subTitulo = subTitulo;
        }
    }

    public interface OnModeloRecyclerListener{

        public void onModeloSelected(Modelo modelo);

    }

}
