package com.example.json.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoInfo extends DialogFragment {

    private String nombre;

    public static DialogoInfo newInstance(String nombre) {

        Bundle args = new Bundle();
        args.putString("nombre", nombre);
        DialogoInfo dialogo = new DialogoInfo();
        dialogo.setArguments(args);
        return dialogo;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        nombre = getArguments().getString("nombre");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Estas seguro que el" + nombre+ " es tu equipo favorito");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    public interface OnDialogoConfirm{
        void onDialogoSelected();
    }
}
