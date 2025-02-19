package com.example.navegacion.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.google.firebase.auth.FirebaseAuth

class DialogoConfirmacion: DialogFragment() {

    private lateinit var nombre: String;
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        nombre = requireArguments().getString("nombre")!!
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Registro completo")
        builder.setMessage("Enhobuena ${nombre}, ¿quieres logearte directamente?")
        builder.setPositiveButton("SI"){_,_->
            // login al fragment main
            findNavController().navigate(R.id.action_dialogoConfirmacion_to_fragmentMain)
        }
        builder.setNegativeButton("NO"){_,_->
            // deslogeo
            auth.signOut()
            findNavController().navigate(R.id.action_dialogoConfirmacion_to_fragmentLogin)
        }
        return builder.create()
    }
}