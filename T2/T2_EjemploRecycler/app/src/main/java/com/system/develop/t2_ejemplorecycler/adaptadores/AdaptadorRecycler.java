package com.system.develop.t2_ejemplorecycler.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.system.develop.t2_ejemplorecycler.MainActivity;
import com.system.develop.t2_ejemplorecycler.R;
import com.system.develop.t2_ejemplorecycler.utils.Persona;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    List list;
    Context context;
    OnPersonaRecyclerListener onPersonaRecyclerListener;

    public AdaptadorRecycler(List list, Context context) {
        this.list = list;
        this.context = context;
        //p.getNombre();
        // igualar a la clase que implementa
        onPersonaRecyclerListener = (OnPersonaRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_frame, viewGroup, false);
        MiHolder holder = new MiHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder miHolder, int i) {
        final Persona p = (Persona) list.get(i);
        miHolder.getImagen().setImageResource(p.getImagen());
        miHolder.getNombre().setText(p.getNombre());
        miHolder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Toast.makeText(context,String.valueOf(isChecked),Toast.LENGTH_SHORT).show();

                if(isChecked){
                    onPersonaRecyclerListener.onPersonaRecyclerSelected(p);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;
        CheckBox checkBox;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenRecycler);
            nombre = itemView.findViewById(R.id.textoRecycler);
            checkBox = itemView.findViewById(R.id.checkRecycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

    public abstract interface OnPersonaRecyclerListener {
        public void onPersonaRecyclerSelected(Persona persona);
    }


}
