package com.borja.t04_vistarrecicladas.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t04_vistarrecicladas.MainActivity;
import com.borja.t04_vistarrecicladas.R;
import com.borja.t04_vistarrecicladas.RecyclerNormalActivity;
import com.borja.t04_vistarrecicladas.utils.Persona;

import java.util.ArrayList;

public class AdaptadorRecycler
        extends RecyclerView.Adapter<AdaptadorRecycler.HolderAdapterPropio> {

    Context ctx;
    ArrayList<Persona> listaPersonas;
    OnMiRecyclerListener listener;

    public AdaptadorRecycler(Context context,
                             ArrayList<Persona> listaPersonas) {
        this.ctx = context;
        this.listaPersonas = listaPersonas;
        listener = (OnMiRecyclerListener) ctx;

        // listener = RecyclerNormalActivity;
        // listener = Activity;
    }

    // crea el contenedor que sirve para rellenar las filas
    @NonNull
    @Override
    public HolderAdapterPropio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.recycler_layout,
                parent,false);
        HolderAdapterPropio miHolder = new HolderAdapterPropio(view);
        return miHolder;
    }
    //
    @Override
    public void onBindViewHolder(@NonNull HolderAdapterPropio holder, int position) {
        final Persona actual = listaPersonas.get(position);
        holder.getNombre().setText(actual.getNombre());
        holder.getApellido().setText(actual.getApellido());
        if (actual.getSexo() == 0){
            holder.getImagen().setImageResource(R.drawable.man);
        } else if (actual.getSexo() == 1){
            holder.getImagen().setImageResource(R.drawable.woman);
        } else {
            holder.getImagen().setImageResource(R.drawable.ic_launcher_background);
        }



        holder.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMiRecycler(actual);
            }
        });

        holder.getLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"Layout",Toast.LENGTH_SHORT).show();
            }
        });

    }

    // retorna el numero de elementos que tendra el recycler
    // retorna el número de elementos que tendra la lista
    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    //
    class HolderAdapterPropio extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView nombre,apellido;
        private LinearLayout layout;

        public HolderAdapterPropio(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_fila);
            nombre = itemView.findViewById(R.id.nombre_fila);
            apellido = itemView.findViewById(R.id.apellido_fila);
            layout = itemView.findViewById(R.id.layout_recycler);
        }

        public LinearLayout getLayout() {
            return layout;
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

    public interface OnMiRecyclerListener{
        public void onMiRecycler(Persona persona);
    }
}
