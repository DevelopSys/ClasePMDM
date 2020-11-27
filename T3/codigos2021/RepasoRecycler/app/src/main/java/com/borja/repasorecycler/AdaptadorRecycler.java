package com.borja.repasorecycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderPropio> {

    private Context context;
    private List<Persona> listaDatos;
    private OnPersonaListener listener;

    public AdaptadorRecycler(Context context, List<Persona> listaDatos) {
        this.context = context;
        this.listaDatos = listaDatos;
        try {
            listener = (OnPersonaListener) context;
        } catch (ClassCastException e){
            Log.e("Error","No se ha podido castear");
        }

    }

    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_fila,parent,false);
        return new HolderPropio(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPropio holder, int position) {

        Persona persona = listaDatos.get(position);

        holder.getDatoUno().setText(persona.getNombre());
        holder.getDatoDos().setText(persona.getApellido());
        holder.getBoton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,persona.getNombre(),Toast.LENGTH_SHORT).show();
                listener.onPersonaSelected(persona);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public interface OnPersonaListener{

        void onPersonaSelected(Persona persona);

    }

    class HolderPropio extends RecyclerView.ViewHolder{

        private TextView datoUno, datoDos;
        private Button boton;

        public HolderPropio(@NonNull View itemView) {
            super(itemView);
            datoUno = itemView.findViewById(R.id.texto1);
            datoDos = itemView.findViewById(R.id.texto2);
            boton = itemView.findViewById(R.id.boton_detalle);
        }

        public Button getBoton() {
            return boton;
        }

        public TextView getDatoUno() {
            return datoUno;
        }

        public TextView getDatoDos() {
            return datoDos;
        }
    }

}


