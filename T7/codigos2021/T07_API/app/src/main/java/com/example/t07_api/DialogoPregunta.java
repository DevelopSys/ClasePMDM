package com.example.t07_api;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoPregunta extends DialogFragment {

    private View view;
    private ImageButton botonOk, botonFail;
    private OnDialogoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnDialogoListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        view = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialogo,null,false);
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        botonFail = view.findViewById(R.id.boton_incorrecto);
        botonOk = view.findViewById(R.id.boton_correcto);
        botonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDialogoSelected(true);
                dismiss();
            }
        });
        botonFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDialogoSelected(false);
                dismiss();
            }
        });
    }

    public interface OnDialogoListener{
        void onDialogoSelected(boolean respuesta);
    }

}
