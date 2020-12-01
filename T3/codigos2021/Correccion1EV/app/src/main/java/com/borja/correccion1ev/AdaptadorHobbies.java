package com.borja.correccion1ev;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorHobbies extends RecyclerView.Adapter<AdaptadorHobbies.HolderHobbie>  {

    private Context context;
    private ArrayList<Elemento> lista;
    OnElementoRecyclerListener listener;

    public AdaptadorHobbies(Context context, ArrayList<Elemento> lista) {
        this.context = context;
        this.lista = lista;
        try {
            this.listener = (OnElementoRecyclerListener) context;
        } catch (ClassCastException e){
            Log.v("error_cast", "No se puede castear");
        }

    }


    public void limpiarLista(){
        lista.clear();
        notifyDataSetChanged();
    }

    public void agregarElemento(Elemento e){
        lista.add(e);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderHobbie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        return new HolderHobbie(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderHobbie holder, int position) {

        Elemento elemento = lista.get(position);
        holder.getImagen().setImageResource(elemento.getImagen());
        holder.getNombre().setText(elemento.getNombre());
        holder.getDetalle().setText(elemento.getDetalle());
        holder.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onElementoSelected(elemento);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnElementoRecyclerListener{
        void onElementoSelected(Elemento elemento);
    }

    class HolderHobbie extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView nombre,detalle;

        public HolderHobbie(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_fila);
            nombre = itemView.findViewById(R.id.nombre_fila);
            detalle = itemView.findViewById(R.id.detalle_fila);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getDetalle() {
            return detalle;
        }
    }

}
