package com.example.dialogos.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.DataSet
import com.example.dialogos.model.Pregunta

class QuestionDialog : DialogFragment() {

    private lateinit var pregunta: Pregunta
    private lateinit var listener: OnPreguntaListener
    private var seleccion: Int = -1

    companion object {
        fun newInstance(x: Pregunta): QuestionDialog {
            val dialog: QuestionDialog = QuestionDialog();
            val bundle = Bundle();
            bundle.putSerializable("pregunta", x)
            dialog.arguments = bundle
            return dialog;
        }

    }

    // onAttach -> recupero los argumentos
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnPreguntaListener;
        pregunta = arguments?.getSerializable("pregunta") as Pregunta
    }

    // onCreateDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(pregunta.titulo)
        builder.setSingleChoiceItems(pregunta.respuestas, -1, { _, i ->
            seleccion = i;
        })
        builder.setPositiveButton("Seleccionar", { _, _ ->
            // comunicar
            listener.onRespuestaSelected(seleccion)
        })
        return builder.create()
    }

    // onStart
    // onResume

    interface OnPreguntaListener {
        fun onRespuestaSelected(x: Int)
    }

}