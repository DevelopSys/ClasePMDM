package com.system.develop.t3_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class DialogoSiNo extends DialogFragment {

    String titulo;
    OnDialogoSINOListener listener;

    public static DialogoSiNo newInstance(String titulo) {
        DialogoSiNo dialogoSiNo = new DialogoSiNo();
        Bundle b = new Bundle();
        b.putString("titulo", titulo);
        dialogoSiNo.setArguments(b);
        return dialogoSiNo;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnDialogoSINOListener) context;
        }catch (ClassCastException e){
            Log.v("error","error al castear");
        }
        if (this.getArguments() != null) {
            //Bundle b = this.getArguments();
            titulo = getArguments().getString("titulo");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage("¿Estas seguro que quieres contuniar?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoSiSelected("Si pulsado");
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoNoSelected("No pulsado");
            }
        });
        builder.setNeutralButton("CERRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoNeutralSelected("Neutral pulsado");
            }
        });
        return builder.create();
    }

    public interface OnDialogoSINOListener {
        public void onDialogoSiSelected(String s);
        public void onDialogoNoSelected(String s);
        public void onDialogoNeutralSelected(String s);
    }
}
