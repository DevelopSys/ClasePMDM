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

public class DialogoItems extends DialogFragment {

    OnDialogoItemSelected listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoItemSelected) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle(R.string.titulo_dialogo_items);
        
        dialogo.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onItemSelected(opciones[i]);
            }
        });


        return dialogo.create();
    }

    public interface OnDialogoItemSelected{
        public void onItemSelected(String s);
    }
}
