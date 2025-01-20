package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.icu.text.Edits
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.R

class DialogoLogin : DialogFragment() {

    private lateinit var vista: View
    private lateinit var editCorreo: EditText
    private lateinit var editPass: EditText
    private lateinit var boton: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_view, null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editPass = vista.findViewById(R.id.editPass)
        editCorreo = vista.findViewById(R.id.editCorreo)
        boton = vista.findViewById(R.id.btnIniciar)

        boton.setOnClickListener {
            Log.v(
                "dialogo",
                "correo: ${editCorreo.text.toString()} " +
                        "pass: ${editPass.text.toString()}"
            )
        }
    }
}