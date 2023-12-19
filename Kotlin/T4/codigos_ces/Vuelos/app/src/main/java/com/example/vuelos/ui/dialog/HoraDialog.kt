package com.example.vuelos.ui.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class HoraDialog : DialogFragment() {

    private lateinit var contexto: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        /*buider: title, messaje, positive*/
        return TimePickerDialog(
            contexto, contexto as OnTimeSetListener,
            1, 30, true
        )
    }

    override fun onDetach() {
        super.onDetach()
    }

}