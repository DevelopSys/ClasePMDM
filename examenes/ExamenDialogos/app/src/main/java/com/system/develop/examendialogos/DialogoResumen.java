package com.system.develop.examendialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DialogoResumen extends DialogFragment {

    String nombre;
    int nota;
    View v;

    public static DialogoResumen newInstance(String nombre, int nota) {

        DialogoResumen d = new DialogoResumen();
        Bundle b = new Bundle();
        b.putString("nombre", nombre);
        b.putInt("nota", nota);
        d.setArguments(b);
        return d;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getArguments() != null) {
            nombre = getArguments().getString("nombre");
            nota = getArguments().getInt("nota");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Examen PMDM");
        String mensaje = "Enhorabuena %s, has aprobado el examen con un %d";
        builder.setMessage(String.format(mensaje, nombre, nota));
        builder.setView(v);
        return builder.create();
    }


}
