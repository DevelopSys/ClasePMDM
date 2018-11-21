package com.system.develop.t2_cardview.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.develop.t2_cardview.R;
import com.system.develop.t2_cardview.utils.DataSet;
import com.system.develop.t2_cardview.utils.Juego;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder> {

    OnRecyclerListener onRecyclerListener;
    Context context;
    List<Juego> listaDatos;

    public AdaptadorRecycler(Context context) {
        this.context = context;
        listaDatos = DataSet.newInstance().darJuegos();
        onRecyclerListener = (OnRecyclerListener) context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        Holder h = new Holder(v);
        return h;
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        final Juego j = listaDatos.get(i);
        holder.getImagen().setImageResource(j.getImagen());
        holder.getNombre().setText(j.getNombre());
        holder.getBoton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerListener.onJuegoSelected(j);
            }
        });
        holder.botonBorrar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                borrarElemento(j);
                return true;
            }
        });
    }

    public void borrarElemento(Juego juego){
        listaDatos.remove(juego);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        View layout;
        ImageView imagen;
        TextView nombre;
        Button boton, botonBorrar;

        public Holder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layoutRecycler);
            imagen = itemView.findViewById(R.id.imagenRecyclerItem);
            nombre = itemView.findViewById(R.id.nombreRecyclerItem);
            boton = itemView.findViewById(R.id.botonItemRecycler);
            botonBorrar = itemView.findViewById(R.id.botonBorrarItemRecycler);
        }

        public Button getBoton() {
            return boton;
        }

        public View getLayout() {
            return layout;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }
    }

    public interface OnRecyclerListener{
        public void onJuegoSelected(Juego juego);
    }
}
