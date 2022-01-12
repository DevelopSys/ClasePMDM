package com.example.t4_recycler.adaptadores;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.t4_recycler.R;

import org.w3c.dom.Text;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {

    

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView textoNombre, textoTelefono;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textoNombre = itemView.findViewById(R.id.nombre_fila);
            textoTelefono = itemView.findViewById(R.id.telefono_fila);
        }
    }
}
