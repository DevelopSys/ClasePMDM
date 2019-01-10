package com.system.develop.t4_ejemploexamenrec.dialogo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.system.develop.t4_ejemploexamenrec.R;
import com.system.develop.t4_ejemploexamenrec.utils.Peliculas;

public class DialogoPelicula extends DialogFragment {

    View v;
    ImageView imagen;
    String url;
    Peliculas p;
    Context c;

    public static DialogoPelicula newInstance(String url){

        DialogoPelicula dialogoPelicula = new DialogoPelicula();
        Bundle bundle = new Bundle();
        bundle.putString("imagen",url);
        dialogoPelicula.setArguments(bundle);
        return dialogoPelicula;
    }

    public static DialogoPelicula newInstance(Peliculas peliculas){

        DialogoPelicula dialogoPelicula = new DialogoPelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable("pelicula",peliculas);
        dialogoPelicula.setArguments(bundle);
        return dialogoPelicula;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.layout_dialogo,null);
        if (this.getArguments() != null){
            //url = getArguments().getString("imagen");
            p = (Peliculas) getArguments().getSerializable("pelicula");
        }
        c = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        imagen = v.findViewById(R.id.imagenDialogo);
        registerForContextMenu(imagen);
        //Picasso.with(c).load(url).into(imagen);
        Picasso.with(c).load(p.getUrl()).into(imagen);
        return builder.create();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_ejemplo, menu);

    }
}
