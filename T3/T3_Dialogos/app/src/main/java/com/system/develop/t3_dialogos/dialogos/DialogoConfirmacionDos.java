package com.system.develop.t3_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class DialogoConfirmacionDos extends DialogFragment {

    String titulo;
    final static String TAG_ARG1 ="argumento1";
    public static DialogoConfirmacionDos newInstance(String titulo){

        DialogoConfirmacionDos dialogoConfirmacionDos = new DialogoConfirmacionDos();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacionDos.setArguments(b);
        return dialogoConfirmacionDos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(this.getArguments()!= null)
        {
            Bundle bRecuperado = this.getArguments();
            titulo = bRecuperado.getString(TAG_ARG1);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage("Diálogo con comunicación");
        builder.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }
}
