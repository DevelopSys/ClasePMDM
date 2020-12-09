package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.borja.t04_dialogos.R;
import com.borja.t04_dialogos.adaptadores.AdaptadorDialogo;
import com.borja.t04_dialogos.utils.Equipo;

import java.util.ArrayList;

public class DialogoSingle extends DialogFragment {

    OnDialogoSingle listener;
    private int posicion;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnDialogoSingle) context;
        } catch (ClassCastException e) {
            Log.v("casteo", "No se ha podido castear");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String[] opciones = {"Opcion1", "Opcion2", "Opcion3"};
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Barcelona","LaLiga", R.drawable.barsa));
        listaEquipos.add(new Equipo("Madrid","LaLiga",R.drawable.madrid));
        listaEquipos.add(new Equipo("Atleti","LaLiga",R.drawable.atleti));

        builder.setTitle("Diálogo lista single");
        /*builder.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //listener.onDialogoSingleListener(opciones[i]);
                //dismiss();
                posicion = i;
            }
        });*/

        //ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_checked,listaEquipos);

        /*builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    posicion = i;
            }
        });*/

        AdaptadorDialogo adaptadorDialogo = new AdaptadorDialogo(getContext(),listaEquipos);

        builder.setSingleChoiceItems(adaptadorDialogo, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSingleEquipoListener(listaEquipos.get(i));
                dismiss();
            }
        });

        builder.setPositiveButton("Comunicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //listener.onDialogoSingleListener(opciones[posicion]);
                listener.onDialogoSingleEquipoListener(listaEquipos.get(posicion));
            }
        });

        return builder.create();
    }

    public interface OnDialogoSingle {
        void onDialogoSingleListener(String opcion);
        void onDialogoSingleEquipoListener (Equipo equipo);
    }
}
