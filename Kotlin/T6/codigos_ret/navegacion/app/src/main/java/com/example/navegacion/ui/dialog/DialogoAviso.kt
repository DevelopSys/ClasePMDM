package com.example.navegacion.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.google.firebase.auth.FirebaseAuth

class DialogoAviso : DialogFragment() {

    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance();
        Log.v("usuario", auth.currentUser?.uid ?: "sin login")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setMessage("No hay usuario usuario. ¿Quieres registrarlo?")
        builder.setPositiveButton("SI") { _, _ ->
            findNavController().navigate(R.id.action_dialogoAviso_to_fragmentRegister)
        }
        builder.setNegativeButton("NO") { _, _ -> dismiss() }
        return builder.create()
    }
}