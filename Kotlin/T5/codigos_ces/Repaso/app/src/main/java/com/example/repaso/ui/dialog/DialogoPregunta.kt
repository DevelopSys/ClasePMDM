package com.example.repaso.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.repaso.adapter.AdapterTrivial
import com.example.repaso.model.Pregunta

class DialogoPregunta : DialogFragment() {

    private lateinit var pregunta: Pregunta
    private var seleccion: String? = null
    private lateinit var listener: OnRespuestaListener

    companion object {
        // variables
        // metodos -> crear una instancia del objeto con parametros
        ;
        fun newInstance(pregunta: Pregunta): DialogoPregunta {
            val dialogoPregunta: DialogoPregunta = DialogoPregunta()
            val bundle: Bundle = Bundle()
            bundle.putSerializable("pregunta", pregunta)
            dialogoPregunta.arguments = bundle
            return dialogoPregunta
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.pregunta = this.arguments?.getSerializable("pregunta") as Pregunta
        this.listener = context as OnRespuestaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(pregunta.question)
        (pregunta.incorrectAnswers as ArrayList<String>)
            .add(pregunta.correctAnswer!!)
        val opciones: Array<CharSequence> = pregunta.incorrectAnswers
                as Array<CharSequence>
        opciones.shuffle();
        builder.setSingleChoiceItems(opciones, -1, { _, i ->
            seleccion = opciones[i].toString()
        })
        builder.setPositiveButton("Seleccionar", { _, _ ->
            // pasar a la activity la opcion seleccionada
            if (seleccion != null) {
                listener.onRespuestaSelected(seleccion!!)
            }
        })
        builder.setNeutralButton("Cancelar", { _, _ -> })

        return builder.create()
    }

    interface OnRespuestaListener {
        fun onRespuestaSelected(opcion: String)
    }
}