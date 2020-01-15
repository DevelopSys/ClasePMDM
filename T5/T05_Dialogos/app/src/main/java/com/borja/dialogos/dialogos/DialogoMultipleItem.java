package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogoMultipleItem extends DialogFragment {


    private int contador;
    private OnDialogoMultiListener listener;
    private ArrayList elementos;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        elementos = new ArrayList();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        final String[]opciones = {"Opción1","Opción2","Opción3","Opción4"};
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Título del diálogo multiple item");

        dialogo.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                /*if (b){
                    contador++;
                }else {
                    contador--;
                }*/
                if (b){
                    elementos.add(opciones[i]);
                }else {
                    elementos.remove(opciones[i]);
                }

            }
        });

        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // TODO comunicar el numero de item seleccionados
                listener.onMultiSelected(contador);
                listener.onMultiSelectedItem(elementos);
            }
        });
        return dialogo.create();
    }

    public interface OnDialogoMultiListener{
        void onMultiSelected(int numero);
        void onMultiSelectedItem(ArrayList arrayList);
    }


}
