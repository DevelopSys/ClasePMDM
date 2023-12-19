package com.example.vuelos.ui.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class FechaDialog : DialogFragment() {

    private lateinit var contexto: Context
    private var mesActual = 0;
    private var diaActual = 0;
    private var anioActual = 0;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;

        val calendar = Calendar.getInstance()
        mesActual = calendar.get(Calendar.MONTH)
        diaActual = calendar.get(Calendar.DAY_OF_MONTH)
        anioActual = calendar.get(Calendar.YEAR)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        /*buider: title, messaje, positive*/
        return DatePickerDialog(
            contexto,
            contexto as OnDateSetListener,
            anioActual,
            mesActual,
            diaActual
        )
    }

    override fun onDetach() {
        super.onDetach()
    }

}