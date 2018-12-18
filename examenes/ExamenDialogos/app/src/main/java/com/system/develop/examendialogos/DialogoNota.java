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
import android.widget.EditText;
import android.widget.Spinner;

public class DialogoNota extends DialogFragment {

    OnNotaListener listener;
    Spinner spinnerNota;
    String nombre;
    View v;

    public static DialogoNota newInstance(String n){

        DialogoNota d = new DialogoNota();
        Bundle b = new Bundle();
        b.putString("nombre",n);
        d.setArguments(b);
        return d;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getArguments()!=null){
            nombre = getArguments().getString("nombre");
        }
        try {
            listener = (OnNotaListener) context;
        } catch (ClassCastException e) {
            Log.v("log", "Error al castear el escuchador");
        }
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_nota, null);
        spinnerNota = v.findViewById(R.id.spinnerNota);
        rellenarSpinner(context);
    }

    private void rellenarSpinner(Context c) {
        String[]numeros = {"0","1","2","3","4","5","6","7","8","9","10"};
        spinnerNota.setAdapter(new ArrayAdapter<CharSequence>(c,android.R.layout.simple_spinner_item,numeros));
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
        builder.setMessage(nombre+" intruduce la nota que piensas que sacarás");
        builder.setView(v);
        builder.setPositiveButton("TERMINAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    listener.onNotaSelected(spinnerNota.getSelectedItemPosition());
            }
        });
        builder.setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

    public interface OnNotaListener {
        public void onNotaSelected(int n);
    }

}
