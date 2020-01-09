package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.borja.dialogos.R;

public class DialogoSINOPerso extends DialogFragment {

    public String nombreRecuperado;
    static final String TAG_ARG1 = "nombre";

    public static DialogoSINOPerso newInstance(String nombre){

        DialogoSINOPerso dialogoSINOPerso = new DialogoSINOPerso();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1,nombre);
        dialogoSINOPerso.setArguments(bundle);
        return dialogoSINOPerso;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nombreRecuperado = this.getArguments().getString(TAG_ARG1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle(R.string.titulo_dialogo_sino_perso);
        dialogo.setMessage(nombreRecuperado+" estas seguro que quieres continuar");
        return dialogo.create();
    }
}
