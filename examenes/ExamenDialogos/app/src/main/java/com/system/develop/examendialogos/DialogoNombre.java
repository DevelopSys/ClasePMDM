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
import android.widget.EditText;

public class DialogoNombre extends DialogFragment {

    OnNombreListener listener;
    EditText editTextNombre;
    View v;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnNombreListener) context;
        } catch (ClassCastException e) {
            Log.v("log", "Error al castear el escuchador");
        }
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_nombre, null);
        editTextNombre = v.findViewById(R.id.editNombre);
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
        builder.setTitle("Examen PMDM");
        builder.setMessage("Para continuar introduce tu nombre por favor");
        builder.setView(v);
        builder.setPositiveButton("SIGUIENTE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!editTextNombre.getText().toString().isEmpty()) {
                    listener.onNombreSelected(editTextNombre.getText().toString());
                }
            }
        });
        builder.setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

    public interface OnNombreListener {
        public void onNombreSelected(String s);
    }

}
