package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoLista extends DialogFragment {


    OnDialogoLista listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
        listener = (OnDialogoLista) context;}
        catch (ClassCastException e){
            Log.v("casteo","No se puede castear");
        }
    }

    // sera llamado cuando cree un objeto de la clase
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String[] opciones = {"Opcion1","Opcion2","Opcion3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getContext(),opciones[i],Toast.LENGTH_SHORT).show();
                listener.onDialogoListaSelectect(opciones[i]);
            }
        });


        builder.setTitle("Diálogo listas");


        return builder.create();
    }
    public interface OnDialogoLista{
        void onDialogoListaSelectect(String opcion);
    }
}
