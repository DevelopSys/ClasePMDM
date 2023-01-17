package com.develop.t5_dialogos.dialogs

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialgoFecha: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // builder
        // setear elementos del builder
        // return builder.create

        val calendarioActual: Calendar = Calendar.getInstance();
        val anio= calendarioActual.get(Calendar.YEAR)
        val dia = calendarioActual.get(Calendar.DAY_OF_MONTH)
        val mes =  calendarioActual.get(Calendar.MONTH)

        val dialogoFecha = DatePickerDialog(requireContext(),requireContext() as OnDateSetListener,anio,mes,dia)
        return dialogoFecha
    }
}