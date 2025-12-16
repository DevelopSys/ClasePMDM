package com.example.tienda.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.model.Producto

class DialogoResultado : DialogFragment() {

    private lateinit var producto1: Producto
    private lateinit var producto2: Producto
    private lateinit var comparacion: String

    companion object {
        fun newInstance(
            producto1: Producto,
            producto2: Producto,
            comparacion: String
        ): DialogoResultado {

            val dialogoResultado = DialogoResultado()
            val bundle = Bundle()
            bundle.putString("comparacion", comparacion)
            bundle.putSerializable("producto1", producto1)
            bundle.putSerializable("producto2", producto2)
            dialogoResultado.arguments = bundle
            return dialogoResultado;
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // recupero los argumentos
        val bundle: Bundle? = this.arguments;
        producto1 = bundle?.getSerializable("producto1") as Producto
        producto2 = bundle?.getSerializable("producto2") as Producto
        comparacion = bundle?.getString("comparacion").toString()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // el xlm -> layout inflater
        // builder.setView()
        // extraer cada elemento del xml -> binding / findViewById

        builder.setTitle(comparacion)
        builder.setMessage("El producto es ${producto1.nombre}")
        return builder.create()
    }

}