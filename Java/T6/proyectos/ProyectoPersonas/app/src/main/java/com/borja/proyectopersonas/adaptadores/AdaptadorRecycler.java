package com.borja.proyectopersonas.adaptadores;

import android.content.Context;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.proyectopersonas.R;
import com.borja.proyectopersonas.utils.Persona;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {


    private Context context;
    private ArrayList<Persona> listaPersonas;
    private OnRecyclerListener listener;

    public AdaptadorRecycler(Context context, ArrayList<Persona> listaPersonas) {
        this.context = context;
        this.listaPersonas = listaPersonas;
        try {
            listener = (OnRecyclerListener) context;
        } catch (ClassCastException e) {

        }
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new MiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Persona persona = listaPersonas.get(position);
        holder.getImageView().setImageResource(persona.getImagen());
        holder.getToolbar().inflateMenu(R.menu.menu_item);
        holder.getToolbar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        holder.getToolbar().setTitle(persona.getNombre());


    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public interface OnRecyclerListener {
        void onPersonaSelected(Persona persona);
    }

    class MiHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private Button button;
        private Toolbar toolbar;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_item_recycler);
            button = itemView.findViewById(R.id.boton_item_recycler);
            toolbar = itemView.findViewById(R.id.toobar_item);
        }

        public Toolbar getToolbar() {
            return toolbar;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public Button getButton() {
            return button;
        }
    }

}
