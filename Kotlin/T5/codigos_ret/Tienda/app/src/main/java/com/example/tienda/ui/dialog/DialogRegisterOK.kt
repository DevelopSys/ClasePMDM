package com.example.tienda.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.google.firebase.auth.FirebaseAuth

class DialogRegisterOK : DialogFragment() {

    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder =
            AlertDialog.Builder(requireContext())

        builder.setTitle("Usuario creado")
        builder.setMessage("Usuario creado correctamente, ¿quieres iniciar sesion?")
        builder.setPositiveButton("SI"){_,_->
            findNavController().navigate(R.id.action_dialogRegisterOK_to_fragmentMain)
        }
        builder.setNegativeButton("NO"){_,_->
            auth.signOut()
            findNavController().navigate(R.id.action_dialogRegisterOK_to_fragmentLogin)
        }

        return builder.create()
    }

}