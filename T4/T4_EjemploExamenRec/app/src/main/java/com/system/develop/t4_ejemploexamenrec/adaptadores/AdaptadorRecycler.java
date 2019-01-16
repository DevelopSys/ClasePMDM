package com.system.develop.t4_ejemploexamenrec.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.system.develop.t4_ejemploexamenrec.R;
import com.system.develop.t4_ejemploexamenrec.utils.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderRecycler> {

    Context context;
    List<Peliculas> listaPeliculas;
    OnPeliculaListener listener;

    public AdaptadorRecycler(Context context) {
        this.context = context;
        listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Peliculas("Eduardo manos tijeras", "https://image.tmdb.org/t/p/w500/kgLTB53HinftRRwhft7yrUOclDC.jpg"));
        listaPeliculas.add(new Peliculas("Sombras tenebrosas", "https://image.tmdb.org/t/p/w500/6125p54Jnog3kFsY33oMQF3d1dJ.jpg"));
        listaPeliculas.add(new Peliculas("Big fish", "https://image.tmdb.org/t/p/w500/6DRFdlNZpAaEt7eejsbAlJGgaM7.jpg"));
        listaPeliculas.add(new Peliculas("Batman", "https://image.tmdb.org/t/p/w500/kBf3g9crrADGMc2AMAMlLBgSm2h.jpg"));
        listaPeliculas.add(new Peliculas("Bitelchus", "https://image.tmdb.org/t/p/w500/upAwc1kPQJU1ZWeMgEWV8Lp6CWb.jpg"));
        listaPeliculas.add(new Peliculas("Frankenweenie", "https://image.tmdb.org/t/p/w500/gWnW7vxm8yr01TVLQhL4aI02orp.jpg"));
        listaPeliculas.add(new Peliculas("Big eyes", "https://image.tmdb.org/t/p/w500/z2tqzprHojhgEGYKQepjU28oQg6.jpg"));
        listener = (OnPeliculaListener) context;
    }


    @NonNull
    @Override
    public HolderRecycler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        return new HolderRecycler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycler holderRecycler, final int i) {
        final Peliculas p = listaPeliculas.get(i);

        Picasso.with(context).load(p.getUrl()).into(holderRecycler.getImagen());
        holderRecycler.getToolbar().setTitle(p.getTitulo());
        holderRecycler.getToolbar().inflateMenu(R.menu.menu_toolbar);
        holderRecycler.getToolbar().setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.itemMenuInfo:
                        //Toast.makeText(context, p.getTitulo(), Toast.LENGTH_SHORT).show();
                        //listener.onImagenSelected(p.getUrl());
                        listener.onPeliculaSelected(p);
                        break;
                    case R.id.itemMenuEliminar:
                        listaPeliculas.remove(p);
                        //notifyDataSetChanged();
                        notifyItemRemoved(i);
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    class HolderRecycler extends RecyclerView.ViewHolder {

        Toolbar toolbar;
        ImageView imagen;

        public HolderRecycler(@NonNull View itemView) {
            super(itemView);
            toolbar = itemView.findViewById(R.id.toolbarCarta);
            imagen = itemView.findViewById(R.id.imagenCarta);
        }

        public Toolbar getToolbar() {
            return toolbar;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }

    public interface OnPeliculaListener{
        public void onPeliculaSelected(Peliculas peliculas);
        public void onImagenSelected(String string);
    }
}
