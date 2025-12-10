package com.example.tienda.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tienda.dataset.DataSet

class DialogoConfirmacionCompra : DialogFragment() {

    private lateinit var listener: OnDilogoConfirmacionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDilogoConfirmacionListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Confirmacion")
        builder.setMessage("¿Estas seguro que quieres confirmar la compra de los productos?")

        builder.setPositiveButton("SI", { view, pos ->
            listener.onConfirmacionSelected()
        })

        return builder.create()
    }

    interface OnDilogoConfirmacionListener {
        fun onConfirmacionSelected()
    }
}

/*
{ _, _ ->
            {
                Log.v("comunicacion","pulsacion dialogo detectada")

                // borrar los productos ->
                // eliminar los productos del recycler -> adapter
                // adapter.notify -> adapter
                // dataset.remove -> desde cualquier lado
                // DataSet.listaCarrito.clear()
                listener.onConfirmacionSelected()
            }
 */