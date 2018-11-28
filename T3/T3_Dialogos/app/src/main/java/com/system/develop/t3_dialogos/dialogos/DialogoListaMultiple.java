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

public class DialogoListaMultiple extends DialogFragment {

    OnDialogoListaListener listener;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try{
            listener = (OnDialogoListaListener) context;
        }catch (ClassCastException e){
            Log.v("error","error en el casteo");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] opciones = {"sdfsdf","sdfsdfsdf","qrwtghgnfbv"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("TITULO LISTA MULTIPLE");
        //builder.setMessage("asdasd");
        builder.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //builder.setMu
        return builder.create();
    }

    public interface OnDialogoListaListener{
        public void onElementoListaSelected(String s);
    }
}
