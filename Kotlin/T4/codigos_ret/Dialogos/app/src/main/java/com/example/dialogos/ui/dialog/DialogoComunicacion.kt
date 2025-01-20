package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoComunicacion : DialogFragment() {

    private lateinit var nombre: String;
    private lateinit var pass: String;

    companion object {
        fun newInstance(nombre: String, pass: String): DialogoComunicacion {
            val dialog: DialogoComunicacion = DialogoComunicacion();
            val bundle: Bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putString("pass", pass)
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // capturo los datos
        nombre = this.arguments?.getString("nombre") ?: "sin nombre"
        pass = this.arguments?.getString("pass") ?: "sin pass"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Confirmacion")
        builder.setMessage("Por favor XXX, confirmas que tu pass es XXX")
        return builder.create()
    }

}