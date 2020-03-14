package com.borja.t07_sqlite.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t07_sqlite.R;
import com.borja.t07_sqlite.utils.Usuario;

import java.util.ArrayList;

public class ConsultaAdapter extends RecyclerView.Adapter<ConsultaAdapter.HolderRecycler> {

    ArrayList<Usuario> listaUsuarios;
    Context context;

    public ConsultaAdapter(Context context) {
        this.listaUsuarios = new ArrayList<>();
        this.context = context;
    }

    public void agregarUsuario (Usuario usuario){
        listaUsuarios.add(usuario);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_consulta,parent,false);
        return new HolderRecycler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycler holder, int position) {

        Usuario actual = listaUsuarios.get(position);
        holder.getNombre().setText(actual.getNombre());
        holder.getApellido().setText(actual.getApellido());

    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    class HolderRecycler extends RecyclerView.ViewHolder{

        private TextView nombre;
        private TextView apellido;

        public HolderRecycler(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textview_consulta_nombre);
            apellido = itemView.findViewById(R.id.textview_consulta_apellido);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }
    }

}
