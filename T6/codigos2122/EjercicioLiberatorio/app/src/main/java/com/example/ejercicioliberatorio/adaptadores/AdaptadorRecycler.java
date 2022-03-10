package com.example.ejercicioliberatorio.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioliberatorio.R;
import com.example.ejercicioliberatorio.utils.Pregunta;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {

    ArrayList<Pregunta> preguntas;
    Context context;
    OnPreguntaListener listener;

    public AdaptadorRecycler(Context context) {
        this.context = context;
        preguntas = new ArrayList<>();
        listener = (OnPreguntaListener) context;
    }

    public void addPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fila, parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Pregunta pregunta = preguntas.get(position);
        holder.textView.setText(pregunta.getPregunta());
        if (position%2==0){
            holder.linear.setBackgroundColor(context.getColor(R.color.purple_200));
        }else {
            holder.linear.setBackgroundColor(context.getColor(R.color.teal_200));
        }
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPreguntaSelected(pregunta);
            }
        });
    }

    public interface OnPreguntaListener{
        void onPreguntaSelected(Pregunta pregunta);
    }

    @Override
    public int getItemCount() {
        return preguntas.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        LinearLayout linear;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.linear_pregunta);
            textView = itemView.findViewById(R.id.texto_pregunta);
        }
    }
}
