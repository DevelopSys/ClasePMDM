package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoComunicacion extends DialogFragment {

    private String nombre;

    public static DialogoComunicacion newInstance(String nombre){

        DialogoComunicacion d = new DialogoComunicacion();
        Bundle bundle = new Bundle();
        bundle.putString("nombre",nombre);
        d.setArguments(bundle);
        // despues de retornar se ejecuta el ciclo de vida completo
        return d;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments()!= null){
            this.nombre = this.getArguments().getString("nombre");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            // personalidazo
        // como puedo hacer para poner en el mensaje el nombre que me han pasado
        // por parametros
        builder.setMessage(nombre);
        return builder.create();
    }
}
