package com.system.develop.t3_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.system.develop.t3_dialogos.R;

public class DialogoPerso extends DialogFragment {

    Button bOK, bCancel;
    EditText editNombre,editApellido,editEdad;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_perso,null);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        instancias();
        acciones();
        builder.setView(v);
        return builder.create();
    }

    private void acciones() {
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void instancias() {
        bOK = v.findViewById(R.id.okDialogo);
        bCancel = v.findViewById(R.id.cancelDialogo);
        editNombre = v.findViewById(R.id.nombreDialogo);
        editApellido = v.findViewById(R.id.apellidoDialogo);
        editEdad = v.findViewById(R.id.edadDialogo);
    }
}
