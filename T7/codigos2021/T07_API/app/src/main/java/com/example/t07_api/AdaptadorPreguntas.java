package com.example.t07_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPreguntas extends RecyclerView.Adapter<AdaptadorPreguntas.MyHolder> {

    private ArrayList<Pregunta> listaPreguntas;
    private Context context;
    private OnRecyclerListener listener;

    public AdaptadorPreguntas(Context context) {
        this.listaPreguntas = new ArrayList<>();
        this.context = context;
        listener = (OnRecyclerListener) context;
    }

    public void addPregunta(Pregunta pregunta){
        listaPreguntas.add(pregunta);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Pregunta pregunta = listaPreguntas.get(position);
        holder.text.setText(pregunta.getEnunciado());
        if (position%2 == 0){
            holder.linearLayout.setBackgroundColor(context.getColor(R.color.purple_200));
        } else {
            holder.linearLayout.setBackgroundColor(context.getColor(R.color.teal_200));
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPreguntaSelected(pregunta);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPreguntas.size();
    }

    public interface OnRecyclerListener{
        void onPreguntaSelected(Pregunta p);
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView text;
        LinearLayout linearLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.texto_pregunta);
            linearLayout = itemView.findViewById(R.id.linear_pregunta);
        }
    }

}
