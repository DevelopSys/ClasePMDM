package com.system.develop.t4_correxamen.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.system.develop.t4_correxamen.R;
import com.system.develop.t4_correxamen.utils.Asignatura;
import com.system.develop.t4_correxamen.utils.DataSet;

import java.util.List;

public class AdaptadorRecycer extends RecyclerView.Adapter<AdaptadorRecycer.ViewHolder> {

    Context context;
    List list;
    OnAsignaturaSelectedListener listener;

    public AdaptadorRecycer(Context context, int n) {
        this.context = context;
        listener = (OnAsignaturaSelectedListener) context;
        switch (n) {
            case 0:
                list = DataSet.newInstance().darAf();
                break;
            case 1:
                list = DataSet.newInstance().darAsir();
                break;
            case 2:
                list = DataSet.newInstance().darDam();
                break;
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Asignatura asignatura = (Asignatura) list.get(i);
        viewHolder.getImageView().setImageResource(asignatura.getImagen());
        viewHolder.getTextView().setText(asignatura.getNombre());
        viewHolder.getLinear().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAsignaturaSelected(asignatura);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnAsignaturaSelectedListener{
        public void onAsignaturaSelected(Asignatura a);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagenRecycler);
            textView = itemView.findViewById(R.id.textRecycler);
            linear = itemView.findViewById(R.id.linearItem);
        }

        public LinearLayout getLinear() {
            return linear;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
