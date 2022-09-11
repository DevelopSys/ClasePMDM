package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.borja.t04_dialogos.R;

public class DialogoInfoApp extends DialogFragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // intancias --> callback
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.titulo_dialgo_info_app);
        builder.setMessage("Aplicación realizada por Borja para la asignatura de PMDM");

        return builder.create();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        // eliminar interfaz de callback

    }
}
