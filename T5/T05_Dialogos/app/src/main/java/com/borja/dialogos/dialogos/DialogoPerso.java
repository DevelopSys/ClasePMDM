package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.borja.dialogos.R;

public class DialogoPerso extends DialogFragment {


    EditText editNombre, editPass;
    Button botonDialogo;
    View vista;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_perso,null);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        instancias();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setView(vista);
        return dialogo.create();
    }

    private void instancias() {
        editNombre = vista.findViewById(R.id.edit_nombre_dialogo);
        editPass = vista.findViewById(R.id.edit_pass_dialogo);
        botonDialogo =vista.findViewById(R.id.boton_login_dialogo);
    }
}
