package com.develop.t5_dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.develop.t5_dialogos.R
import com.google.android.material.snackbar.Snackbar

class DialogoConfirmacion : DialogFragment() {

    // crear interfaz
    // crear objeto de interfaz
    // inicializo el objeto --> listener =
    // llamo al método desde la pulsacion o accion que quiera
    // implementarla en el destino
    // utilizo los métodos implementados

    private lateinit var listener: OnDialogoConfirmListener;
    var funcionNula: ((Boolean) -> Unit)? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoConfirmListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // Builder --> creador
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // titulo
        builder.setTitle("Titulo del cuadro de confirmación")
        //builder.setTitle(R.string.titulo_dialogo)
        //builder.setTitle( requireContext().resources.getString(R.string.titulo_dialogo))

        // mensaje
        builder.setMessage("¿Estás seguro que quieres continuar el proceso?")

        // botones
        builder.setPositiveButton("OK") { dialogInterface, i ->
            funcionNula?.invoke(true)
            //listener.onDialogoSelected(true)
            //Toast.makeText(requireContext(),"Pulsado positivo",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("CANCELAR") { dialogInterface, i ->
            funcionNula?.invoke(false)
            //listener.onDialogoSelected(false)
            //Toast.makeText(requireContext(),"Pulsado negativo",Toast.LENGTH_SHORT).show()
        }

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogoConfirmListener {
        fun onDialogoSelected(seleccionado: Boolean)
    }

    // dependiendo de la pulsacion se contesta a la activity el resultado
    // en el caso de boton neutral, desaparece el cuadro

}