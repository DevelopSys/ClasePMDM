package com.example.dialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos.R;

public class DialogoLogin extends DialogFragment {

    private Context context;
    private View view;
    private Button botonLogin;
    private EditText editNombre, editPass;
    private CheckBox checkPass;
    private OnDialogoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (OnDialogoListener) context;
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_login,null,false);
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();
    }

    private void acciones() {
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNombre.getText().toString().equalsIgnoreCase("user")
                && editPass.getText().toString().equals("pass")
                && checkPass.isChecked()){
                    //Toast.makeText(context, "Login correcto",Toast.LENGTH_SHORT).show();
                    listener.onDialogoSelected(editNombre.getText().toString(), editPass.getText().toString());
                    dismiss();
                } else {
                    Toast.makeText(context, "Login incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface OnDialogoListener{
        void onDialogoSelected(String nombre, String pass);
    }

    private void instancias() {
        botonLogin = view.findViewById(R.id.boton_login);
        editNombre = view.findViewById(R.id.edit_nombre_login);
        editPass = view.findViewById(R.id.edit_pass_login);
        checkPass = view.findViewById(R.id.check_login_pass);
        // Al pulsar el boton, si el user y pass coinciden con
        // user y pass y ademas el check esta true
        // que saque un toast con LOGIN CORRECTO,
        // en caso contrario LOGIN INCORRECTO
    }
}
