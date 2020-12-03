package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoConfirmacion extends DialogFragment {

    Context context;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("¿Estás seguro?");
        builder.setMessage("Por favor indica si quieres cerrar la aplicación");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"SEGURO QUE QUIERO CERRAR",Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getContext(),"SEGURO QUE NO QUIERO CERRAR",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        builder.setNeutralButton("NO SE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"SEGURO QUE NO QUIERO CERRAR",Toast.LENGTH_SHORT).show();
                //dismiss();
            }
        });


        return builder.create();
    }
}
