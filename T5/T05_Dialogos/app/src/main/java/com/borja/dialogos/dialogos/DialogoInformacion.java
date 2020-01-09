package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.borja.dialogos.R;

public class DialogoInformacion extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle(R.string.titulo_dialogo_info);
        dialogo.setMessage(R.string.mensaje_dialogo_info);
        //dialogo.setMessage(getResources().getString(R.string.mensaje_dialogo_info));
        return dialogo.create();
    }
}
