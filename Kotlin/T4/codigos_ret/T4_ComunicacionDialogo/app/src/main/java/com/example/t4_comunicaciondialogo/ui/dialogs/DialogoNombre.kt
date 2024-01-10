package com.example.t4_comunicaciondialogo.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t4_comunicaciondialogo.R

class DialogoNombre: DialogFragment() {

    private lateinit var contexto: Context
    private lateinit var boton: Button
    private lateinit var editNombre: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder: AlertDialog.Builder = AlertDialog.Builder(contexto)
        // -> el XML
        val vista = LayoutInflater.from(contexto)
            .inflate(R.layout.dialogo_nombre,null)
        editNombre = vista.findViewById(R.id.edit_nombre)
        boton = vista.findViewById(R.id.boton_nombre)
        builder.setView(vista)


        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        boton.setOnClickListener {
            editNombre.text.toString()
        }
    }

}