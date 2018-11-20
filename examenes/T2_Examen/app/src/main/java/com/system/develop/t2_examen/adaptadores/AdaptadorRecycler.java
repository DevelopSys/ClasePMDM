package com.system.develop.t2_examen.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.develop.t2_examen.R;
import com.system.develop.t2_examen.utils.Generico;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderRecycler> {

    Context c;
    List lista;
    int posicion;
    OnRecyclerListener onRecyclerListener;

    public AdaptadorRecycler(Context c, int posicion) {
        this.c = c;
        lista = new ArrayList();
        switch (posicion) {
            case 0:
                lista.add(new Generico("El cabo del miedo","Sony" , R.drawable.cabo));
                lista.add(new Generico("Harry Potter", "Paramount",R.drawable.harry));
                lista.add(new Generico("El gran lebosky", "Filmac", R.drawable.levo));
                lista.add(new Generico("Scream", "Filmac",R.drawable.scream));
                lista.add(new Generico("Taxi", "Sony",R.drawable.taxi));
                lista.add(new Generico("Start Wars", "Lucas Film",R.drawable.star));
                break;
            case 1:
                lista.add(new Generico("Donky Kong", "Nintendo",R.drawable.donk));
                lista.add(new Generico("God of War", "Sony",R.drawable.kratos));
                lista.add(new Generico("Sonic", "Sega",R.drawable.sonic));
                lista.add(new Generico("Street Fighter", "Konami",R.drawable.street));
                lista.add(new Generico("Zelda", "Nintendo",R.drawable.zelda));
                break;
            case 2:
                lista.add(new Generico("Arturo Vidal", "Chile",R.drawable.arturo));
                lista.add(new Generico("Karim Benzema", "Francia",R.drawable.benzema));
                lista.add(new Generico("Leo Messi", "Argentina", R.drawable.leo));
                lista.add(new Generico("Luka Modric", "Croacia",R.drawable.luka));
                break;
        }

        onRecyclerListener = (OnRecyclerListener) c;
    }


    @NonNull
    @Override
    public HolderRecycler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_recycler, viewGroup, false);
        HolderRecycler h = new HolderRecycler(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycler holderRecycler, int i) {
        final Generico generico = (Generico) lista.get(i);
        holderRecycler.getImageView().setImageResource(generico.getImagen());
        holderRecycler.getNombre().setText(generico.getNombre());
        holderRecycler.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerListener.onRecyclerSelected(generico);
            }
        });
    }

    public abstract interface OnRecyclerListener{
        public void onRecyclerSelected(Generico generico);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class HolderRecycler extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nombre;

        public HolderRecycler(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imagenRecycler);
            nombre = itemView.findViewById(R.id.nombreRecycler);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getNombre() {
            return nombre;
        }
    }
}
