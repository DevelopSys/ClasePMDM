package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.R

class DialogoLogin : DialogFragment() {

    private lateinit var vista: View
    private lateinit var buton: Button;
    private lateinit var editCorreo: EditText
    private lateinit var editPass: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialog_login,
            null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        buton = vista.findViewById(R.id.botonLogin)
        editPass = vista.findViewById(R.id.editPass)
        editCorreo = vista.findViewById(R.id.editCorreo)
    }

    override fun onResume() {
        super.onResume()
        buton.setOnClickListener {
            // validar
            // comunicar a la activity datos - acciones
            dismiss()
        }
    }
}