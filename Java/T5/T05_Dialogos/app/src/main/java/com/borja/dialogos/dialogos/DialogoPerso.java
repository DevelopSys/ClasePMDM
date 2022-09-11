package com.borja.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.borja.dialogos.R;
import com.borja.dialogos.utils.Persona;

public class DialogoPerso extends DialogFragment {


    EditText editNombre, editPass;
    Button botonDialogo;
    View vista;
    OnDialogoPersoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnDialogoPersoListener) context;
        } catch (ClassCastException e){
            Log.v("cast","ni de coña");
        }


        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_perso,null);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        instancias();
        acciones();
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setView(vista);
        return dialogo.create();
    }

    private void acciones() {
        botonDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = new Persona(editNombre.getText().toString(),
                        editPass.getText().toString());
                listener.onDilagoloSelected(persona);
                dismiss();
            }
        });
    }

    private void instancias() {
        editNombre = vista.findViewById(R.id.edit_nombre_dialogo);
        editPass = vista.findViewById(R.id.edit_pass_dialogo);
        botonDialogo =vista.findViewById(R.id.boton_login_dialogo);
    }

    public interface OnDialogoPersoListener{
        void onDilagoloSelected(Persona persona);
    }
}
