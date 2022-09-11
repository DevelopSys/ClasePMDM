package com.borja.t06_masterdetail.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.borja.t06_masterdetail.R;
import com.borja.t06_masterdetail.utils.Tecnologia;

public class DialogoAddTec extends DialogFragment {

    private Context context;
    private EditText editNombre, editDescripcion;
    private Button botonAdd;
    private OnDialogoAddListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (OnDialogoAddListener) context;
        //View v = LayoutInflater.from(context).inflate(R.layout.layout_dialogo_add,null);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View v = LayoutInflater.from(context).inflate(R.layout.layout_dialogo_add,null);

        editNombre = v.findViewById(R.id.edit_tecnologia_add);
        editDescripcion = v.findViewById(R.id.edit_tecnologia_des);
        botonAdd = v.findViewById(R.id.button_tec_add);
        builder.setView(v);
        return builder.create();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editDescripcion.getText().toString().isEmpty() || !editDescripcion.getText().toString().isEmpty()){
                    String nombre = editNombre.getText().toString();
                    String descripcion = editDescripcion.getText().toString();
                    Tecnologia tecnologia = new Tecnologia(nombre,descripcion,R.drawable.img_tecnologia);
                    listener.onTecnologiaAdd(tecnologia);
                    //Toast.makeText(getContext(),"Add correctamente",Toast.LENGTH_SHORT).show();
                    dismiss();
                } else {
                    Toast.makeText(getContext(),"Hay algo vacío",Toast.LENGTH_SHORT).show();
                    dismiss();

                }
            }
        });
    }

    public interface OnDialogoAddListener{
        void onTecnologiaAdd(Tecnologia tecnologia);
    }
}
