package com.develop.t06_fragements.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.develop.t06_fragements.R;
import com.develop.t06_fragements.utils.Persona;

import java.util.List;

public class AdaptadorRecyclerPersonas extends RecyclerView.Adapter<AdaptadorRecyclerPersonas.MyHolder> {

    private List<Persona> listaPersonas;
    private Context context;
    private OnPersonaItemListener listener;

    public AdaptadorRecyclerPersonas(List<Persona> listaPersonas, Context context) {
        this.listaPersonas = listaPersonas;
        this.context = context;
        listener = (OnPersonaItemListener) context;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fila_recycler_fragment,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Persona pActual = listaPersonas.get(position);
        holder.getNombre().setText(pActual.getNombre());
        holder.getApellido().setText(pActual.getApellido());
        holder.getImagen().setImageResource(pActual.getImagen());
        holder.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPersonaSelected();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public interface OnPersonaItemListener{
        void onPersonaSelected();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView nombre, apellido;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_fila);
            nombre = itemView.findViewById(R.id.nombre_fila);
            apellido = itemView.findViewById(R.id.apellido_fila);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}
