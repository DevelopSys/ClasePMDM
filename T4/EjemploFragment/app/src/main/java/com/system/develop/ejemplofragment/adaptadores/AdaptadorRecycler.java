package com.system.develop.ejemplofragment.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.system.develop.ejemplofragment.R;
import com.system.develop.ejemplofragment.utils.Persona;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    Context c;
    ArrayList<Persona> lista;
    OnElementoAdaptadorListener listener;

    public AdaptadorRecycler(Context c) {
        this.c = c;
        lista = new ArrayList<>();
        lista.add(new Persona("Nombre1", "Apellido", 224));
        lista.add(new Persona("Nombre2", "Apellido", 224));
        lista.add(new Persona("Nombre3", "Apellido", 224));
        lista.add(new Persona("Nombre4", "Apellido", 224));
        lista.add(new Persona("Nombre5", "Apellido", 224));
        lista.add(new Persona("Nombre6", "Apellido", 224));
        listener = (OnElementoAdaptadorListener) c;
    }


    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler, viewGroup, false);
        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Persona p = lista.get(i);
        miHolder.getNombre().setText(p.getNombre());
        miHolder.getApellido().setText(p.getApellido());
        miHolder.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onElementoSelected(p.getTelefono());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnElementoAdaptadorListener{
        public void onElementoSelected(int telefono);
    }

    class MiHolder extends RecyclerView.ViewHolder {

        TextView nombre, apellido;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.itemNombre);
            apellido = itemView.findViewById(R.id.itemApellido);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }
}
