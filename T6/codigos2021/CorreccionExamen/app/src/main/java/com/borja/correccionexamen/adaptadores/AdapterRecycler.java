package com.borja.correccionexamen.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.correccionexamen.R;
import com.borja.correccionexamen.utils.Persona;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {

    private Context context;
    private ArrayList<Persona> lista;

    public AdapterRecycler(Context context){
        this.context = context;
        lista = new ArrayList<>();
        //lista.add(new Persona("Borja","Martin",18));
    }

    public void addPersona(Persona persona){
        lista.add(persona);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Persona persona = lista.get(position);
        holder.getNombre().setText(persona.getNombre());
        holder.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"asdasd",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView nombre;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_item);
        }

        public TextView getNombre() {
            return nombre;
        }
    }
}
