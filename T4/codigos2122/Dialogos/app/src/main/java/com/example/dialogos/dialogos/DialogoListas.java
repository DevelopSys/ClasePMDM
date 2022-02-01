package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogoListas extends DialogFragment {

    private Context context;
    private int seleccionado = -1;
    private ArrayList listaSeleccionados = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String[] opciones = new String[]{"Opcion 1", "Opcion 2", "Opcion 3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Diálogo de lista");
        /*builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Opcion seleccionada OPCION 3
                Toast.makeText(context,opciones[i], Toast.LENGTH_SHORT).show();
            }
        });*/
        /*builder.setSingleChoiceItems(opciones, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    seleccionado = i;
                Toast.makeText(context, opciones[seleccionado], Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });*/
        boolean[] elementos = new boolean[]{true, false, true};
        builder.setMultiChoiceItems(opciones, elementos, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    if (b){
                        listaSeleccionados.add(opciones[i]);
                    } else {
                        listaSeleccionados.remove(opciones[i]);
                    }
            }
        });


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // al dar al boton OK saldrá un TOAST con el texto
                // Seleccionada OPCION 3
                Toast.makeText(context, String.valueOf(listaSeleccionados.size()), Toast.LENGTH_SHORT).show();
            }
        });


        return builder.create();
    }
}
