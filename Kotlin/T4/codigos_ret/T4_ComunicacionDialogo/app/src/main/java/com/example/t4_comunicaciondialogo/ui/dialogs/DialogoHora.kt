package com.example.t4_comunicaciondialogo.ui.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.os.Bundle
import android.provider.CalendarContract.CalendarAlerts
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoHora : DialogFragment() {

    private lateinit var contexto: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendario = Calendar.getInstance();
        return TimePickerDialog(
            contexto, contexto as OnTimeSetListener,
            calendario.get(Calendar.HOUR_OF_DAY),
            calendario.get(Calendar.MINUTE), true
        )
    }

}