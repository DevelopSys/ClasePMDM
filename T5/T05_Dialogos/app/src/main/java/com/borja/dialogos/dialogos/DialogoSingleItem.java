package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSingleItem extends DialogFragment {


    private OnDialogoSingleItemSelected listener;
    private int posicion;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoSingleItemSelected) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        final String[]opciones = {"Opción1","Opción2","Opción3","Opción4"};
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Título del diálogo single item");

        dialogo.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                posicion = i;
                //dismiss();
            }
        });

        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onSingleItemSelected(opciones[posicion]);
            }
        });
        return dialogo.create();
    }

    public interface OnDialogoSingleItemSelected{
        public void onSingleItemSelected(String item);
    }
}
