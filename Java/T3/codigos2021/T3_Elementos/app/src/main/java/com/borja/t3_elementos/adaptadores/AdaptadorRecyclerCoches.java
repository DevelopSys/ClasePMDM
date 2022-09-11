package com.borja.t3_elementos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t3_elementos.R;
import com.borja.t3_elementos.RecyclerCochesActivity;
import com.borja.t3_elementos.utils.Coche;

import java.util.List;

public class AdaptadorRecyclerCoches extends
        RecyclerView.Adapter<AdaptadorRecyclerCoches.MiHolderCoches> {

    Context context;
    List<Coche> listaCoches;
    OnCocheRecyclerListener listener;

    public AdaptadorRecyclerCoches(Context context, List<Coche> listaCoches) {
        this.context = context;
        this.listaCoches = listaCoches;
        listener = (OnCocheRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolderCoches onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_coche_recycler, parent, false);
        MiHolderCoches holder = new MiHolderCoches(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderCoches holder, int position) {

        final Coche cocheActual = listaCoches.get(position);
        holder.getModelo().setText(cocheActual.getModelo());
        holder.getImagen().setImageResource(cocheActual.getImagen());
        holder.getBtnDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onCocheSelected();
                listener.onCocheSelected(cocheActual);
            }
        });
        holder.getBtnDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onCocheLongSelected();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaCoches.size();
    }

    public interface OnCocheRecyclerListener{
        void onCocheSelected(Coche coche);
        void onCocheLongSelected();
    }

    class MiHolderCoches extends RecyclerView.ViewHolder {

        TextView modelo;
        ImageView imagen;
        Button btnDetalle;

        public MiHolderCoches(@NonNull View itemView) {
            super(itemView);
            modelo = itemView.findViewById(R.id.texto_modelo_recycler);
            imagen = itemView.findViewById(R.id.imagen_coche_recycler);
            btnDetalle = itemView.findViewById(R.id.boton_detalle_recycler);
        }

        public TextView getModelo() {
            return modelo;
        }
        public ImageView getImagen() {
            return imagen;
        }
        public Button getBtnDetalle() {
            return btnDetalle;
        }

    }
}
