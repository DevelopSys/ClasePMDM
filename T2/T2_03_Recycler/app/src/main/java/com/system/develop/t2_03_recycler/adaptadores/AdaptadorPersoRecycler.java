package com.system.develop.t2_03_recycler.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.system.develop.t2_03_recycler.MainActivity;
import com.system.develop.t2_03_recycler.R;
import com.system.develop.t2_03_recycler.utils.Persona;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    List<Persona> listaDatos;
    Context context;
    OnAdaptadorPersoListener adaptadorPersoListener;

    public AdaptadorPersoRecycler(Context context) {
        listaDatos = new ArrayList<Persona>();
        listaDatos.add(new Persona("asd", "asd", 123));
        listaDatos.add(new Persona("cvzcv", "àsfsdg", 123));
        listaDatos.add(new Persona("hddgf", "vbcvb", 123));
        listaDatos.add(new Persona("ppò``o", "cvbcvbcvb", 123));
        this.context = context;
        adaptadorPersoListener = (OnAdaptadorPersoListener) context;
    }

    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        HolderPropio holderPropio = new HolderPropio(v);
        return holderPropio;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
        final Persona p = listaDatos.get(i);
        holderPropio.getNombre().setText(p.getNombre());
        holderPropio.getApellido().setText(p.getApellido());
        holderPropio.getTelefono().setText(String.valueOf(p.getTelefono()));
        holderPropio.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, p.getNombre(), Toast.LENGTH_SHORT).show();
                adaptadorPersoListener.onAdaptadorPersoSelected(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public interface OnAdaptadorPersoListener{
        public void onAdaptadorPersoSelected(Persona persona);
    }

    class HolderPropio extends RecyclerView.ViewHolder {

        TextView nombre, apellido, telefono;
        LinearLayout linearLayout;


        public HolderPropio(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreItem);
            telefono = itemView.findViewById(R.id.telefonoItem);
            apellido = itemView.findViewById(R.id.apellidItem);
            linearLayout = itemView.findViewById(R.id.layoutItem);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }

        public TextView getTelefono() {
            return telefono;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }
}
