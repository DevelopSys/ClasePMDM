package com.example.t4_recycler.adaptadores;

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


import com.example.t4_recycler.R;
import com.example.t4_recycler.utils.Contacto;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {

    private ArrayList<Contacto> listaContactos;
    private Context context;

    public AdaptadorRecycler(ArrayList<Contacto> listaContactos, Context context) {
        this.listaContactos = listaContactos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        // se pinta cada una de las filas
        Contacto contacto = listaContactos.get(position);
        holder.textoNombre.setText(contacto.getNombre());
        holder.textoTelefono.setText(String.valueOf(contacto.getTelefono()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, contacto.getDireccion(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return listaContactos.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView textoNombre, textoTelefono;
        ImageView imagen;
        LinearLayout linearLayout;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textoNombre = itemView.findViewById(R.id.nombre_fila);
            textoTelefono = itemView.findViewById(R.id.telefono_fila);
            imagen = itemView.findViewById(R.id.imagen_fila);
            linearLayout = itemView.findViewById(R.id.linear_fila_recycler);
        }
    }
}
