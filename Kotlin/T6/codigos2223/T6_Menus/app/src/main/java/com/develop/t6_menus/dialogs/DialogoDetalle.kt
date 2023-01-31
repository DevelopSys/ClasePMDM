package com.develop.t6_menus.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.develop.t6_menus.R
import com.develop.t6_menus.model.Asignatura

class DialogoDetalle: DialogFragment() {

    companion object{
        fun newInstance(asignatura: Asignatura):DialogoDetalle {
            val args = Bundle()
            args.putSerializable("asignatura", asignatura)
            val dialogo = DialogoDetalle()
            dialogo.arguments = args
            return dialogo
        }
    }

    // vista
    private lateinit var vista: View;
    private lateinit var textoNombre: TextView
    private lateinit var textoSiglas: TextView
    private lateinit var asignatura: Asignatura


    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.personalizado_dialogo_detalle,null)
        asignatura = arguments?.getSerializable("asignatura") as Asignatura
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        textoNombre = vista.findViewById(R.id.nombre_detalle)
        textoSiglas = vista.findViewById(R.id.siglas_detalle)
    }

    override fun onResume() {
        super.onResume()
        textoNombre.setText(asignatura.nombre)
        textoSiglas.setText(asignatura.siglas)
    }
}