package com.example.tienda.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R

class DialogRegisterOK : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder =
            AlertDialog.Builder(requireContext())

        builder.setTitle("Usuario creado")
        builder.setMessage("Usuario creado correctamente, ¿quieres iniciar sesion?")
        builder.setPositiveButton("SI"){_,_->
            findNavController().navigate(R.id.action_dialogRegisterOK_to_fragmentMain)
        }
        builder.setNegativeButton("NO"){_,_->
            findNavController().navigate(R.id.action_dialogRegisterOK_to_fragmentLogin)
        }

        return builder.create()
    }

}