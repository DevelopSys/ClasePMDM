package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoComunicar extends DialogFragment {

    private String titulo="Titulo";

    public static DialogoComunicar newInstance(String titulo) {

        Bundle bundle = new Bundle();
        DialogoComunicar dialogoComunicar = new DialogoComunicar();
        bundle.putString("titulo", titulo);
        dialogoComunicar.setArguments(bundle);
        return dialogoComunicar;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments() != null) {
            this.titulo = this.getArguments().getString("titulo");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        return builder.create();
    }
}
