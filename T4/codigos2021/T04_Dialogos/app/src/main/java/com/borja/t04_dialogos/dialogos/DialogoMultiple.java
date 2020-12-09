package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.borja.t04_dialogos.R;
import com.borja.t04_dialogos.utils.Equipo;

import java.util.ArrayList;

public class DialogoMultiple extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Diálogo seleccion multiple");

        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Barcelona","LaLiga", R.drawable.barsa));
        listaEquipos.add(new Equipo("Madrid","LaLiga",R.drawable.madrid));
        listaEquipos.add(new Equipo("Atleti","LaLiga",R.drawable.atleti));
        boolean[]seleccionados = {false,true,true};

        String[] equiposNombre = {"Barsa","Madrid","Atleti"};

        builder.setMultiChoiceItems(equiposNombre, seleccionados, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });

        /*builder.setPositiveButton("Comunicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });*/


        return builder.create();
    }
}
