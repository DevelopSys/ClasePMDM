package com.borja.t06_masterdetail.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t06_masterdetail.R;
import com.borja.t06_masterdetail.utils.Tecnologia;


import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecyclerTec extends RecyclerView.Adapter<AdaptadorRecyclerTec.Miholder> {

    List<Tecnologia> listaTecnologias;
    Context context;
    OnFragmentTecnologiaListener listener;

    public AdaptadorRecyclerTec(List<Tecnologia> listaTecnologias, Context context) {
        this.listaTecnologias = listaTecnologias;
        this.context = context;
        listener = (OnFragmentTecnologiaListener) context;
    }


    @NonNull
    @Override
    public Miholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(context).inflate(R.layout.item_tecnologia_recycler,parent,false);
        return new Miholder(vista);
    }


    @Override
    public void onBindViewHolder(@NonNull Miholder holder, int position) {

        final Tecnologia tecnologia = listaTecnologias.get(position);

        holder.getImagen().setImageResource(tecnologia.getLogo());
        holder.getTexto().setText(tecnologia.getNombre());


        holder.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Pulsado lenguaje", Toast.LENGTH_SHORT).show();
                listener.onTecnologiaSelected(tecnologia);
            }
        });


    }


    @Override
    public int getItemCount() {
        return listaTecnologias.size();
    }


    public interface OnFragmentTecnologiaListener{
        void onTecnologiaSelected(Tecnologia tecnologia);
    }

    class Miholder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView texto;

        public Miholder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.texto_recycler);
            imagen = itemView.findViewById(R.id.image_recycle);


        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getTexto() {
            return texto;
        }

        public void setTexto(TextView texto) {
            this.texto = texto;
        }
    }
}
