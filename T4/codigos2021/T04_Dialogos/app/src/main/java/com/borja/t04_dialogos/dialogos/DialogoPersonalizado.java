package com.borja.t04_dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.borja.t04_dialogos.R;

public class DialogoPersonalizado extends DialogFragment {

    private View view;
    private Button botonDialogo;
    private EditText editNombre, editPass;
    private CheckBox check;
    private OnDialogoPersoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_layout,null);
        try{
            listener = (OnDialogoPersoListener) context;
        } catch (ClassCastException e){
            Toast.makeText(getContext(),"No se puede castear", Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setView(R.layout.dialogo_layout);
        builder.setView(view);
        botonDialogo = view.findViewById(R.id.boton_dialogo);
        editNombre = view.findViewById(R.id.nombre_dialogo);
        editPass = view.findViewById(R.id.pass_dialogo);
        check = view.findViewById(R.id.check_dialogo);
        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        botonDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Pulsado",Toast.LENGTH_SHORT).show();

                String nombre = editNombre.getText().toString(),
                        pass = editPass.getText().toString();

                if (nombre.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getContext(),"Alguno de los datos es vacío",Toast.LENGTH_SHORT).show();
                } else {
                    // Comunicar con la activity
                    listener.onDialogoPersoSelected(nombre,pass,check.isChecked());
                }

                dismiss();
            }
        });
    }

    public interface OnDialogoPersoListener{
        void onDialogoPersoSelected(String nombre, String pass, boolean check);
    }
}
