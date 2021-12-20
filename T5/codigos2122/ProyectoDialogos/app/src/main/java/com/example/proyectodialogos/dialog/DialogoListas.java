package com.example.proyectodialogos.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoListas extends DialogFragment {

    private Context context;
    private String opcionSeleccionada;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        CharSequence[] opciones = new CharSequence[]{"Opcion1","Opcion2","Opcion3"};
        alertDialog.setTitle("Diálogo de listas");
        /*alertDialog.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,opciones[i] , Toast.LENGTH_SHORT).show();
            }
        });*/
        /*alertDialog.setSingleChoiceItems(opciones, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                opcionSeleccionada = (String) opciones[i];
                Toast.makeText(context,opciones[i] , Toast.LENGTH_SHORT).show();
            }
        });*/
        alertDialog.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });


        alertDialog.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Opcion seleccionada "+opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }
        });


        return alertDialog.create();
    }
}
