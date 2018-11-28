package com.system.develop.t3_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogoConfirmacion extends DialogFragment {

    OnDialogoConfirmacionListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Diálogo Confirmación");
        builder.setMessage("Mensaje del diálogo confirmación");
        builder.setNeutralButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss();
                /*Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismiss();
                    }
                },2000);*/
                listener.onDialogoConfirmacionSelected();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnDialogoConfirmacionListener) context;
        }catch (ClassCastException exception){
            Log.v("test","no se ha podido instanciar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnDialogoConfirmacionListener{
        public void onDialogoConfirmacionSelected();
    }
}
