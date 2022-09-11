package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.borja.dialogos.R;

public class DialogoSiNo extends DialogFragment {

    OnDialogoSINOListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoSINOListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle(R.string.titulo_dialogo_sino);
        dialogo.setMessage(R.string.mensaje_dialogo_sino);
        dialogo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //System.out.println("Pulsado no");
                listener.onDialogoSelected("no");
            }
        });
        dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //System.out.println("Pulsado si");
                listener.onDialogoSelected("si");
            }
        });

        dialogo.setNeutralButton("NOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //System.out.println("Pulsado nose");
                listener.onDialogoSelected("nose");
            }
        });

        return dialogo.create();
    }

    public interface OnDialogoSINOListener{
        void onDialogoSelected(String s);
    }


}
