package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoComunicacion : DialogFragment() {

    private lateinit var nombre: String
    private lateinit var asignatura: String

    companion object {
        fun newInstance(nombreParam: String, asignaturaParam: String): DialogoComunicacion {
            val dialogo = DialogoComunicacion()
            val bundle = Bundle()
            bundle.putString("nombre",nombreParam)
            bundle.putString("asignatura",asignaturaParam)
            dialogo.arguments = bundle
            return dialogo;
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val bundleRecuperado = this.arguments
        this.nombre = bundleRecuperado!!.getString("nombre")!!
        this.asignatura = bundleRecuperado!!.getString("asignatura")!!
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Bienvendo ${nombre}")
        builder.setMessage("Estas seguro que te quieres matricular en ${asignatura}")
        builder.setPositiveButton("Si"){_,_->}
        builder.setNegativeButton("No"){_,_->}
        return builder.create()
    }
}