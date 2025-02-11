package com.example.navegacion.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R

class DialogoConfirmacion: DialogFragment() {

    private lateinit var nombre: String;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        
        nombre = requireArguments().getString("nombre")!!
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Registro completo")
        builder.setMessage("Enhobuena ${nombre}, ¿quieres registrarte directamente?")
        builder.setPositiveButton("SI"){_,_->
            // login al fragment main
        }
        builder.setNegativeButton("NO"){_,_->
            findNavController().navigate(R.id.action_dialogoConfirmacion_to_fragmentLogin)
        }
        return builder.create()
    }
}